package com.lorelib.rpc.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by listening on 2017/1/8.
 */
public class HelloClient {
    private final ManagedChannel channel;
    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public HelloClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();
        blockingStub = HelloServiceGrpc.newBlockingStub(channel);
    }

    private void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void hello(String name) {
        HelloRequest request = HelloRequest.newBuilder().setWord(name).build();
        HelloReply reply = blockingStub.helloString(request);
        System.out.println(reply.getMessage());
    }

    public static void main(String[] args) {
        HelloClient client = new HelloClient("localhost", 8100);
        for (int i = 0; i < 5; i++) {
            client.hello("luomm: " + i);
        }
    }
}
