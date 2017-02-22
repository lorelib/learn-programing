package com.lorelib.rpc.thrift.server;

import com.lorelib.rpc.thrift.HelloService;
import com.lorelib.rpc.thrift.HelloServiceImpl;
import com.lorelib.rpc.thrift.UserService;
import com.lorelib.rpc.thrift.UserServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by listening on 2017/1/6.
 */
public class MultiServiceServer {
    private static void startServer() throws TTransportException {
        TServerSocket serverSocket = new TServerSocket(8010);
        TBinaryProtocol.Factory protocol = new TBinaryProtocol.Factory(true, true);

        HelloService.Processor helloService = new HelloService.Processor(new HelloServiceImpl());
        UserService.Processor userService = new UserService.Processor(new UserServiceImpl());

        TMultiplexedProcessor multiProcessor = new TMultiplexedProcessor();
        multiProcessor.registerProcessor("userService", userService);
        multiProcessor.registerProcessor("helloService", helloService);

        TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverSocket);
        args.protocolFactory(protocol);
        args.processor(multiProcessor);

        TServer server = new TThreadPoolServer(args);
        server.serve();
    }

    public static void main(String[] args) throws TTransportException {
        System.out.println("thrift server start...");
        startServer();
        System.out.println("thrift server end!");
    }
}
