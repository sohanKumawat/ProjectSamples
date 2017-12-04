package com.demo.slk.concurrency.disrupter;

public class LongEvent
{
    private long value;

    public void set(long value)
    {
        this.value = value;
    }
    void clear()
    {
    	this.value = 0;
    }
}
