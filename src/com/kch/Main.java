package com.kch;
// Main class

import javax.swing.*;

public class Main {
    public static final int SCREEN_WIDTH = 1200;    //게임전체 넓이 1200 고정
    public static final int SCREEN_HEIGHT = 720;    //게임전체 높이 720 고정
    public static int COUNT = 0; //게임 점수
    final static int FPS = 15;

    public static void main(String[] args) {
        long score = System.currentTimeMillis();
        long scoreProsess;
        ScoreControl sc = new ScoreControl();
        Gui gui = new Gui();


        while(true){
            scoreProsess = System.currentTimeMillis();

            if(scoreProsess - score >= (3000.0)) {
                score = scoreProsess;
                ++COUNT;
                sc.setScore(COUNT);
                sc.scoreRender();
            }
        }
    }
}
