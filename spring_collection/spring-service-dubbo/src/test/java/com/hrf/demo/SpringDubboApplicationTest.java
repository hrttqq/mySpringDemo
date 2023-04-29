package com.hrf.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple SpringDubboApplication.
 */
public class SpringDubboApplicationTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void test(){
        ThreadPoolExecutor e = new ThreadPoolExecutor(10, 100, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        e.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("111111");
            }
        });
    }
}
