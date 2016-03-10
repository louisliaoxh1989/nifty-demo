package com.jonsen.nifty.demo.server;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.jonsen.nifty.demo.thrift.HelloService;

public class NiftyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TTransport transport = new TSocket("localhost", 7790);
		transport.open();
		TProtocol protocol = new TBinaryProtocol(transport);
		HelloService.Client client = new HelloService.Client(protocol);
		System.out.println(client.sayHello("aa"));
		transport.close();
	}

}
