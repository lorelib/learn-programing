package com.lorelib.rpc.thrift.server;

import com.lorelib.rpc.thrift.HelloService;
import com.lorelib.rpc.thrift.HelloServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by listening on 2017/1/5.
 */
public class SingleServiceServer {
    private static void startServer() throws TTransportException {
        TServerSocket serverSocket = new TServerSocket(8000);
        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory(true, true);
        HelloService.Processor processor = new HelloService.Processor(new HelloServiceImpl());

        TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverSocket);
        args.protocolFactory(factory);
        args.processor(processor);

        TServer server = new TThreadPoolServer(args);
        server.serve();
    }

    public static void main(String[] args) throws TTransportException {
        System.out.println("thrift server start");
        startServer();
        System.out.println("thrift server stop");
    }
}
