package com.checker.app;

public class ObjectWithState {

    private int count;

    public ObjectWithState(int count) {
        this.count = count;
    }

    public synchronized void incCount(){
        this.count+=1;
    }
}
