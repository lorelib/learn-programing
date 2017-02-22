package com.lorelib.rpc.thrift.client;

import com.lorelib.rpc.thrift.HelloService;
import com.lorelib.rpc.thrift.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by listening on 2017/1/6.
 */
public class MultiServiceClient {
    private static void startClient() throws TException {
        TSocket transport = new TSocket("localhost",8010);
        TProtocol protocol = new TBinaryProtocol(transport);

        // 与单服务不同之处在于TMultiplexedProtocol
        TMultiplexedProtocol userProto = new TMultiplexedProtocol(protocol, "userService");
        UserService.Client userClient = new UserService.Client(userProto);

        TMultiplexedProtocol helloProto = new TMultiplexedProtocol(protocol, "helloService");
        HelloService.Client helloClient = new HelloService.Client(helloProto);
        transport.open();

        System.out.println("获取用户信息: " + userClient.getUser("listening").toString());
        System.out.println("hello: " + helloClient.helloString("listening"));

        transport.close();
    }

    public static void main(String[] args) throws TException {
        System.out.println("thrift server start...");
        startClient();
        System.out.println("thrift server end!");
    }
}
