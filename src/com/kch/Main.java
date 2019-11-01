package com.kch;
// Main class

<<<<<<< HEAD
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
=======
import com.kch.entity.Shit;
import com.kch.storage.FileStorage;

import java.io.File;

public class Main {
    public static final int SCREEN_WIDTH = 600;    //게임전체 넓이 600 고정
    public static final int SCREEN_HEIGHT = 850;    //게임전체 높이 850 고정

    public static void main(String[] args) {
        FileStorage.load();
>>>>>>> 6194663c8f9f3fee74082e7ac22d053833db273d
        Gui gui = new Gui();

        //Shit s = new Shit(SCREEN_WIDTH, SCREEN_HEIGHT, 0.0f);

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
