package com.xu.mca.local.greenhouse;

/**
 * java_study
 */
abstract public class Event {
    private long evtTime;
    public Event(long eventTime) {
        this.evtTime = eventTime;
    }
    public boolean ready() {
        return System.currentTimeMillis() >= evtTime;
    }
    abstract public void action();
    abstract public String description();

}
