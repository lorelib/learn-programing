package com.lorelib.rpc.thrift.client;

import com.lorelib.rpc.thrift.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by listening on 2017/1/6.
 */
public class SingleServiceClient {
    private static void startClient() throws TException {
        TTransport transport = new TSocket("localhost", 8000);
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloService.Client client = new HelloService.Client(protocol);
        transport.open();
        System.out.println(client.helloString("listening"));
        transport.close();
    }

    public static void main(String[] args) throws TException {
        System.out.println("thrift client start");
        startClient();
        System.out.println("thrift client stop");
    }
}
