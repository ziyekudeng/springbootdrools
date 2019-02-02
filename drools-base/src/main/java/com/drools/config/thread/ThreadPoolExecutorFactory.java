package com.drools.config.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * 创建时间：2018/一月/15
 * <p>
 * 类名：ThreadPoolExecutorFactory
 * 描述：线程池工厂
 */
public class ThreadPoolExecutorFactory {

    private ThreadPoolExecutorFactory() {
    }

    /**
     * CORE_POOL_SIZE 池中所保存的线程数，包括空闲线程。
     */
    private static final int CORE_POOL_SIZE = 40;
    /**
     * MAXIMUM_POOL_SIZE - 池中允许的最大线程数(采用LinkedBlockingQueue时没有作用)。
     */
    private static final int MAXIMUM_POOL_SIZE = 40;
    /**
     * KEEP_ALIVE_TIME -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，线程池维护线程所允许的空闲时间
     */
    private static final int KEEP_ALIVE_TIME = 60;
    /**
     * 线程池对象
     */
    private static ThreadPoolExecutor threadPoolExecutor = null;

    /**
     * 获取执行线程
     *
     * @return 返回线程执行
     */
    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (null == threadPoolExecutor) {
            ThreadPoolExecutor t;
            synchronized (ThreadPoolExecutor.class) {
                t = threadPoolExecutor;
                if (null == t) {
                    synchronized (ThreadPoolExecutor.class) {
                        t = new ThreadPoolExecutor(CORE_POOL_SIZE,
                                MAXIMUM_POOL_SIZE,
                                KEEP_ALIVE_TIME,
                                MILLISECONDS,
                                new LinkedBlockingQueue<>(),
                                new ThreadPoolExecutor.DiscardOldestPolicy());
                    }
                    threadPoolExecutor = t;
                }
            }
        }
        return threadPoolExecutor;
    }
}