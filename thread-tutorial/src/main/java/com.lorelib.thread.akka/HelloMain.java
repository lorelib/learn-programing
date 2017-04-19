package com.lorelib.thread.akka;

import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;

/**
 * Created by listening on 2017/4/18.
 */
public class HelloMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("Hello", ConfigFactory.load());
    }
}
