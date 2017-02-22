package com.lorelib.rpc.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Created by listening on 2017/1/7.
 */
public class HelloServer {
    private int port = 8100;
    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        HelloServer server = new HelloServer();
        server.startServer();
        server.blockUntilShutdown();
    }

    private void startServer() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl()).build().start();
        System.out.println("service start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("shutting down grpc server since JVM is shutting down.");
                try {
                    HelloServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) server.shutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) server.awaitTermination();
    }
}
