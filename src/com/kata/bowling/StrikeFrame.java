package com.kata.bowling;

public class StrikeFrame implements Frame{
    private int nextFrameScore = 0;

    public StrikeFrame(int nextFrameScore){
        this.nextFrameScore = nextFrameScore;
    }

    @Override
    public int getScore() {
        if(nextFrameScore > 10){
            nextFrameScore = 10;
        }
        return 10 + nextFrameScore;
    }
}
