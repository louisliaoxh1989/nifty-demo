package com.jonsen.nifty.demo.server;
import org.apache.thrift.TProcessor;

import com.facebook.nifty.core.NettyServerTransport;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.nifty.core.ThriftServerDefBuilder;
import com.jonsen.nifty.demo.thrift.HelloService;
import com.jonsen.nifty.demo.thrift.HelloServiceImpl;

public class NiftyServer {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the handler
		HelloService.Iface serviceInterface = new HelloServiceImpl();

		// Create the processor
		TProcessor processor = new HelloService.Processor<HelloService.Iface>(serviceInterface);

		// Build the server definition
		ThriftServerDef serverDef = new ThriftServerDefBuilder().listen(7790)
				.withProcessor(processor).build();

		// Create the server transport
		final NettyServerTransport server = new NettyServerTransport(serverDef);

		// Start the server
		server.start();

		// Arrange to stop the server at shutdown
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					server.stop();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		System.out.println("服务器启动成功...");

	}

}
