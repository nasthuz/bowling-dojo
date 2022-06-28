package com.kata.bowling;

public class SpareFrame implements Frame {
    private int firstTryNextFrame = 0;

    public SpareFrame(int firstTry){
        this.firstTryNextFrame = firstTry;
    }
    @Override
    public int getScore() {
        return 10 + firstTryNextFrame;
    }
}
