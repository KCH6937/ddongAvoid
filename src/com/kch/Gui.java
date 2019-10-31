package com.kch;
import com.kch.entity.Player;
import com.kch.storage.FileStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
/**
 * @author 이상훈(kebin0613@github.com)
 * @since 2019-10-31
 *
 * */
//  gui 클래스
public class Gui extends JFrame {
    Graphics2D graphicDraw;

    Player player = new Player(Main.SCREEN_WIDTH/2,0,0,0);    // 스피드, 가속도는 나중에 추가설정
    public Gui() {


        setTitle("똥피하기");       //게임 이름
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);    //전체게임창을 설정
        setResizable(false);    //한번 만들어진 게임창은 임의로 줄이지 못하게 함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //게임창을 종료했을때 프로그램 전체가 종료되게 함 (내부에서 안돌아가게ㅎ는거)
        setVisible(true);   //게임창이 정상적으로 출력하게 하는거
        setLocationRelativeTo(null);      //실행했을때 게임창이 모니터의 중간에 뜨게 함

        graphicDraw = (Graphics2D) getGraphics();

        draw(FileStorage.bufferedImageMap.get("사람"),Main.SCREEN_WIDTH/2,845);


        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {            //키보드를 눌렀을때
                clear();
                BufferedImage image = player.getImage();

                switch (e.getKeyCode()) {
                    case 37:
                        player.left();
                        break;
                    case 39:
                        player.right();
                        break;
                }

                draw(image, player.getPosX(), player.getPosY());
            }

            @Override
            public void keyReleased(KeyEvent e) {           //키보드를 누르고있을때
                System.out.println(e.getKeyCode());
            }
        });
    }

    public void draw(BufferedImage image, int x, int y) {
        graphicDraw.drawImage(image,x,y,null);
    }

    public void clear() {

    }
}
