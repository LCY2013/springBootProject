package com.lcydream.project.springbootfirstdemo.repository;

import com.lcydream.project.springbootfirstdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UserRepository
 * 用户仓储
 * @author Luo Chun Yun
 * @date 2018/12/1 16:32
 */
@Repository
public class UserRepository {

	/**
	 * 用户仓储信息
	 */
	private final ConcurrentMap<Long, User> repository =
		new ConcurrentHashMap<>();

	/**
	 * id自增，原子操作
	 */
	private final AtomicLong idGenerator = new AtomicLong();

	public Boolean save(User user){
		//ID 从1开始
		long id = idGenerator.incrementAndGet();
		user.setId(id);
		//如果id为1时 -> Map中有user
		//那么再存入一个id为1时 -> user1 ->这个时候会返回上面的user
		return repository.put(id,user)==null;
	}

	/**
	 * Collection返回的操作集是不可操作的，readOnly
	 * a set view of the mappings contained in this map
	 * @return 返回一个视图
	 */
	public Collection<User> getAll(){
		return repository.values();
	}
}
