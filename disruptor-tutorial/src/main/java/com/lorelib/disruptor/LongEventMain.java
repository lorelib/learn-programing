package com.lorelib.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by listening on 2017/2/19.
 */
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = Executors.privilegedThreadFactory();
        LongEventFactory factory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, threadFactory);
        /*Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(
                factory,
                bufferSize,
                threadFactory,
                ProducerType.SINGLE,
                new BlockingWaitStrategy());*/
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        long start = System.currentTimeMillis();
        for (long l = 0; l < 1000; l++) {
            bb.putLong(0, l);
            producer.onData(bb);
        }
        long end = System.currentTimeMillis();
        Thread.sleep(10000);
        System.out.println("run time: " + (end - start));
        disruptor.shutdown();
    }
}
