package com.lcydream.project.springbootconfiguration.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Car
 *
 * @author Luo Chun Yun
 * @date 2018/11/27 14:58
 */
@ConfigurationProperties(prefix="car.cn")
public class Car {

	private String bmw;

	private Host host;

	public String getBmw() {
		return bmw;
	}

	public void setBmw(String bmw) {
		this.bmw = bmw;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public static class Host{
		private String ip;

		private String addr;

		private Integer port;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}
	}
}
