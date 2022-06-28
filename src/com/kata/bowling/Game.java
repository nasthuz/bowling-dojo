package com.kata.bowling;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private int totalPoints = 0;
    private int numberOfFrames = 1;
    private final ArrayList<Frame> frames;

    static final int MAX_FRAMES = 10;

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
        String[] splitedData = data.split(" ");
        int indexOfFrame = 0;
        int firstTry = 0;
        int secondTry = 0;
        HashMap<Integer,ArrayList<Integer>> dataSet = new HashMap<Integer,ArrayList<Integer>>();

        for (String i : splitedData){
            if (i.equals("X")){
                i = "X0";
            }
            String[] frameData = i.split("");
            System.out.print("\n"+ "Frame " + i + " : ");
            ArrayList<Integer> frameDataInt = new ArrayList<Integer>();
            for( String j : frameData){
                if (j.equals("-")){
                    j = "0";
                }else if (j.equals("X")){
                    j = "10";
                }else if (j.equals("/")){
                    j = "12";
                }
                frameDataInt.add(Integer.parseInt(j));
                System.out.print(" " + Integer.parseInt(j) + " ");
            }

            System.out.print(" -  " + frameDataInt.get(0) + " " + frameDataInt.get(1) +  " ");
            firstTry = (int) frameDataInt.get(0);
            secondTry = (int) frameDataInt.get(1);
            dataSet.put(indexOfFrame,frameDataInt);
            System.out.print(" -  " + firstTry + " " + secondTry +  " ");
            indexOfFrame++;
        }
        for(HashMap.Entry<Integer,ArrayList<Integer>> i: dataSet.entrySet()){
            System.out.println("Frame " +  i.getKey() + i.getValue());
            if (i.getValue().get(0) == 10){
                int firstTryStrike = 0;
                int secondTryStrike = 0;
                int nextTriesScore = 0;
                if(i.getKey() == 9 && i.getValue().size() == 3 ){
//                   System.out.println(" Last frame has 3 character  =  " + i.getValue() + " " + dataSet.get(i.getKey()).get(1)+" "+  dataSet.get(i.getKey()).get(2));
                     firstTryStrike = dataSet.get(i.getKey()).get(1);
                     secondTryStrike = dataSet.get(i.getKey()).get(2);
                }else{
//                    System.out.println("X in a middle");
                    firstTryStrike = dataSet.get(i.getKey()+1).get(0);
                    secondTryStrike = dataSet.get(i.getKey()+1).get(1);
                }
                nextTriesScore = firstTryStrike + secondTryStrike;
                System.out.println("\n sum = " + nextTriesScore);
                frames.add(getFrame(i.getValue().get(0), nextTriesScore));
            }else if (i.getValue().get(1) == 12){
                int firstTryNextFrame =0;
                if (i.getKey()== 9 && i.getValue().size() == 3){
                    firstTryNextFrame = dataSet.get(i.getKey()).get(2);
                } else{
                    firstTryNextFrame = dataSet.get(i.getKey()+1).get(0);
                    System.out.println("\nspare = " + firstTryNextFrame);
                }
                frames.add(getFrame(firstTryNextFrame, i.getValue().get(1)));
            }
            else {
                frames.add(getFrame(i.getValue().get(0), i.getValue().get(1)));
            }
        }
        getScore();
    }

    private void getScore() {
        int totalPoints = 0;
        for (Frame i : frames ){
            totalPoints += i.getScore();
        }
//        System.out.println("Score = " + totalPoints);
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