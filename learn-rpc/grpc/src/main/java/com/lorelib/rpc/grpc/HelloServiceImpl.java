package com.lorelib.rpc.grpc;

import io.grpc.stub.StreamObserver;

/**
 * Created by listening on 2017/1/7.
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    public void helloString(HelloRequest req, StreamObserver<HelloReply> respObserver) {
        System.out.println("service: " + req.getWord());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getWord()).build();
        respObserver.onNext(reply);
        respObserver.onCompleted();
    }
}
