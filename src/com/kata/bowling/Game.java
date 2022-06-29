package com.kata.bowling;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private int totalPoints = 0;
    private final ArrayList<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
    }

    public Game(String initData){
        this();
        this.convertInitData(initData);
    }

    public void setTotalPoints(int totalPoints1){
        this.totalPoints = totalPoints1;
    }

    public void convertInitData(String data){
        int indexOfFrame = 0;
        String[] splittedData = data.split(" ");
        HashMap<Integer,ArrayList<Integer>> dataMap = new HashMap<>();
        splitDataIntoFrames(splittedData, indexOfFrame, dataMap);
        try{
            transferData(dataMap);
            getScore();
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
    }

    public void splitDataIntoFrames(String[] splittedData, int indexOfFrame, HashMap<Integer, ArrayList<Integer>> dataMap) {
        for (String i : splittedData){
            if (i.equals("X")){
                i = "X0";
            }
            String[] frameData = i.split("");
            ArrayList<Integer> frameDataInt = new ArrayList<>();
            for( String j : frameData){
                switch (j) {
                    case "-" -> j = "0";
                    case "X" -> j = "10";
                    case "/" -> j = "12";
                }
                frameDataInt.add(Integer.parseInt(j));
            }
            dataMap.put(indexOfFrame,frameDataInt);
            indexOfFrame++;
        }
    }

    public void transferData(HashMap<Integer, ArrayList<Integer>> dataMap) {
        if(dataMap.size() != 10){
            throw new IllegalArgumentException("Invalid number of frames");
        }
        for(HashMap.Entry<Integer,ArrayList<Integer>> i: dataMap.entrySet()){
            int firstTry;
            int secondTry;
            int nextTriesScore;
            if (i.getValue().get(0) == 10){
                
                if(i.getKey() == 9 && i.getValue().size() == 3 ){
                     firstTry = dataMap.get(i.getKey()).get(1);
                     secondTry = dataMap.get(i.getKey()).get(2);
                }else{
                    firstTry = dataMap.get(i.getKey()+1).get(0);
                    secondTry = dataMap.get(i.getKey()+1).get(1);
                }
                nextTriesScore = firstTry + secondTry;
                if(firstTry == 10){
                    nextTriesScore = -1;
                }
                frames.add(getFrame(i.getValue().get(0), nextTriesScore));
            }else if (i.getValue().get(1) == 12){
                if (i.getKey()== 9 && i.getValue().size() == 3){
                    firstTry = dataMap.get(i.getKey()).get(2);
                } else{
                    firstTry = dataMap.get(i.getKey()+1).get(0);
                }
                frames.add(getFrame(firstTry, i.getValue().get(1)));
            }
            else {
                frames.add(getFrame(i.getValue().get(0), i.getValue().get(1)));
            }
        }
    }

    public void getScore() {
        int totalPoints = 0;
        for (Frame i : frames ){
            totalPoints += i.getScore();
        }
        setTotalPoints(totalPoints);
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public Frame getFrame(int firstTry, int secondTry){
        if(firstTry == 10 ){
            return new StrikeFrame(secondTry);
        }if(secondTry == 12){
            return new SpareFrame(firstTry);
        }else{
            return new OpenFrame(firstTry, secondTry);
        }
    }

}
