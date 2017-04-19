package com.lorelib.thread.akka;

import akka.actor.UntypedActor;

/**
 * Created by listening on 2017/4/18.
 */
public class Greeter extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message == Msg.GREET) {
            System.out.println("Hello World!");
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(message);
        }
    }

    public static enum Msg {
        GREET, DONE;
    }
}
