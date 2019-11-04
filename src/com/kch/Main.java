package com.kch;
import com.kch.storage.FileStorage;

public class Main {

    public static final int SCREEN_WIDTH = 600;    //게임전체 넓이 600 고정
    public static final int SCREEN_HEIGHT = 850;    //게임전체 높이 850 고정
    public static int COUNT = 0; //게임 점수
    final static int FPS = 15;

    public static void main(String[] args) {
        FileStorage.load();

        Gui gui = new Gui();

        long score = System.currentTimeMillis();
        long scoreProsess;

        long game = System.currentTimeMillis();
        long gameProsess;


        //Shit s = new Shit(SCREEN_WIDTH, SCREEN_HEIGHT, 0.0f);

        while(true){
            scoreProsess = System.currentTimeMillis();
            gameProsess = System.currentTimeMillis();

            if(scoreProsess - score >= (5000.0 / FPS)) {
//                COUNT++;
//                gui.setScore(COUNT);
                gui.scoreRender();
            }

            if(gameProsess - game >= (1000.0 / FPS)){

            }


        }
    }
}
