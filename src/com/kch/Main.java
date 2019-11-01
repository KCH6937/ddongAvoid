package com.kch;
<<<<<<< HEAD
=======
// Main class

>>>>>>> ac7b13f979422dea71451d73f406a829c60a1eef
import com.kch.entity.Shit;
import com.kch.storage.FileStorage;

import java.io.File;

public class Main {
    public static final int SCREEN_WIDTH = 600;    //게임전체 넓이 600 고정
    public static final int SCREEN_HEIGHT = 850;    //게임전체 높이 850 고정
    public static int COUNT = 0; //게임 점수
    final static int FPS = 15;

    public static void main(String[] args) {
        FileStorage.load();
<<<<<<< HEAD

=======
>>>>>>> ac7b13f979422dea71451d73f406a829c60a1eef
        Gui gui = new Gui();

        long score = System.currentTimeMillis();
        long scoreProsess;

        long game = System.currentTimeMillis();
        long gameProsess;
        ScoreControl sc = new ScoreControl();

        //Shit s = new Shit(SCREEN_WIDTH, SCREEN_HEIGHT, 0.0f);

<<<<<<< HEAD
        while(true){
            scoreProsess = System.currentTimeMillis();
            gameProsess = System.currentTimeMillis();

            if(gameProsess - game >= (1000.0 / FPS)){

            }

            if(scoreProsess - score >= (3000.0)) {
                score = scoreProsess;
                ++COUNT;
                sc.setScore(COUNT);
                sc.scoreRender();
            }
        }
=======
>>>>>>> ac7b13f979422dea71451d73f406a829c60a1eef
    }
}
