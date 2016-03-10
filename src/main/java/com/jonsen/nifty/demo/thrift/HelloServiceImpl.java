package com.jonsen.nifty.demo.thrift;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface{

	@Override
	public String sayHello(String name) throws TException {
		return "Hello," + name;
	}

}
