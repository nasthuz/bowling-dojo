package com.kata.bowling;

public class OpenFrame implements Frame {
    private int firstTry = 0;
    private int secondTry = 0;

    public OpenFrame(int firstTrie, int secondTrie){
        this.firstTry = firstTrie;
        this.secondTry = secondTrie;
    }

    @Override
    public int getScore() {
        return firstTry + secondTry;
    }
}
