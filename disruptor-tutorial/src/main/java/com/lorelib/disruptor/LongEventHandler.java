package com.lorelib.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by listening on 2017/2/19.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event);
    }
}
