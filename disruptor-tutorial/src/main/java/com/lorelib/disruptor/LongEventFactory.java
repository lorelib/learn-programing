package com.lorelib.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by listening on 2017/2/19.
 */
public class LongEventFactory implements EventFactory {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
