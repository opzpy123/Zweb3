package com.opzpy123.zweb3.component.redis.lock.support;

public interface ResourceLock {
    /**
     * 锁定资源,本方法以阻塞方式运行，直到获得锁程序将解除阻塞状态
     */
    void lock();

    /**
     * 尝试锁定资源，本方法以非阻塞方式运行，无论是否获得锁方法将立刻返回
     *
     * @return true：锁定成功，false：锁定失败
     */
    boolean tryLock();


    /**
     * 释放锁定资源
     */
    void unLock();

    /**
     * 取得锁名称
     *
     * @return 锁名称
     */

    String getLockName();

    /**
     * 取得锁保持时间(毫秒)
     *
     * @return 锁保持时间
     */
    long getKeepTime();

}
