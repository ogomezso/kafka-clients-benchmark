package org.github.ogomezso.javaconsumer.infrastructure.kafka;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class ConsumerNetworkInterceptor implements ConsumerInterceptor {

    @Override
    public void configure(Map<String, ?> configs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'configure'");
    }

    @Override
    public ConsumerRecords onConsume(ConsumerRecords records) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onConsume'");
    }

    @Override
    public void onCommit(Map offsets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onCommit'");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

}
