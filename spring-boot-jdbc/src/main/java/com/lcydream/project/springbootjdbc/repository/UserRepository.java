package com.lcydream.project.springbootjdbc.repository;

import com.lcydream.project.springbootjdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Collection;

/**
 * UserRepository
 * {@link User 用户的仓储(sql、或NoSql、或内存型)}
 * @author Luo Chun Yun
 * @date 2018/11/24 16:54
 */
@Repository
public class UserRepository {


	//@Autowired
	/**
	 * 这里可以使用这种方式直接注入
	 * spring提供构造方法注入
	 */
	private final DataSource dataSource;

	private final DataSource masterDataSource;

	private final DataSource slaveDataSource;

	private final JdbcTemplate jdbcTemplate;

	private final PlatformTransactionManager platformTransactionManager;

	/**
	 * 可以直接用构造方法去注入
	 * @param dataSource 注入数据源
	 * @param masterDataSource 主数据源
	 * @param slaveDataSource 从数据源
	 * @param jdbcTemplate 数据模板
	 * @param platformTransactionManager
	 */
	@Autowired
	public UserRepository(DataSource dataSource,
	                      @Qualifier("masterDataSource") DataSource masterDataSource,
	                      @Qualifier("slaveDataSource") DataSource slaveDataSource,
	                      JdbcTemplate jdbcTemplate,
	                      PlatformTransactionManager platformTransactionManager) {
		this.dataSource = dataSource;
		this.masterDataSource = masterDataSource;
		this.slaveDataSource = slaveDataSource;
		this.jdbcTemplate = jdbcTemplate;
		this.platformTransactionManager = platformTransactionManager;
	}

	/**
	 * 利用JDK的数据库规范执行事务的提交
	 * 事务是自动提交的
	 * @param user 用户pojo
	 * @return 操作是否成功
	 */
	public boolean addUser(User user){
        System.out.printf("[Thread: %s ]保存用户信息: %s \n",
		        Thread.currentThread().getName(),user);
        boolean success = false;
		Connection connection = null;
        try{
	        connection = dataSource.getConnection();
	        connection.setAutoCommit(false);

	        //设置还原点
	        Savepoint savePointAddUser = connection.setSavepoint("savePointAddUser");

	        //事物操作
	        try{
	        	transactionalSaveUser(user);
	        }catch (Exception e){
	        	//如果第二个事物失败,返回还原点
		        connection.rollback(savePointAddUser);
	        }
	        //最后提交释放还原点
	        /*connection.commit();
	        connection.releaseSavepoint(savePointAddUser);*/

	        PreparedStatement preparedStatement =
			        connection.prepareStatement("INSERT INTO user(name) VALUES(?) ");
	        preparedStatement.setString(1,user.getName());
	        success = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
        }catch (Exception e){
        	e.printStackTrace();
        }finally{
			if(connection != null){
				try {
					connection.commit();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }

		return success;
	}

	/**
	 * 利用Annotation进行事物的操作
	 * @param user 用户的pojo
	 * @return 操作是否成功
	 */
	@Transactional(rollbackFor = {Exception.class})
	public boolean transactionalSaveUser(User user){
		jdbcTemplate.execute("INSERT INTO user(name) VALUES(?)",
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
						preparedStatement.setString(1,user.getName());
						return preparedStatement.executeUpdate() > 0;
					}
				});
		return false;
	}

	/**
	 * 利用Spring的API进行事物的操作
	 * @param user 用户的pojo
	 * @return 操作是否成功
	 */
	public boolean apiSaveUser(User user){
		boolean success = false;
		DefaultTransactionDefinition transactionDefinition =
				new DefaultTransactionDefinition();
		//获取事物操作工具,开始事物
		TransactionStatus transaction = platformTransactionManager
				.getTransaction(transactionDefinition);
		try{
			jdbcTemplate.execute("INSERT INTO user(name) VALUES(?)",
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
							preparedStatement.setString(1,user.getName());
							return preparedStatement.executeUpdate() > 0;
						}
					});
			platformTransactionManager.commit(transaction);
			success = true;
		}catch (Exception e){
			platformTransactionManager.rollback(transaction);
		}
		return success;
	}

	public Collection<User> findAll(){
		return new ArrayList<>();
	}
}
