package com.kch;
import com.kch.entity.Player;
import com.kch.entity.Shit;

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
    Graphics2D graphicDraw;     //


    Shit shit = new Shit(Main.SCREEN_HEIGHT/2,650,0);       //확실x 건들지마셈

     Player player = new Player(Main.SCREEN_WIDTH/2,810,0,0);    // 스피드, 가속도는 나중에 추가설정해주세요.

    public Gui() {
        setTitle("똥피하기");       //게임 이름
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);    //전체게임창을 설정
        setResizable(false);    //한번 만들어진 게임창은 임의로 줄이지 못하게 함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //게임창을 종료했을때 프로그램 전체가 종료되게 함 (내부에서 안돌아가게하는거)
        setVisible(true);   //게임창이 정상적으로 출력하게 하는거
        setLocationRelativeTo(null);      //실행했을때 게임창이 모니터의 중간에 뜨게 함

        graphicDraw = (Graphics2D) getGraphics();   // getGraphics() 메서드의 반환형이 그냥 Graphics 이므로 Graphics2D 타입으로 명시적형변환(캐스팅)입니다.

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {            //키보드를 눌렀을때
                BufferedImage image = player.getImage();
                BufferedImage imageD = shit.getImage();     //똥 이미지 가져오기
                clear();        // 이전에 그린 사람의 이미지를 지워주는 함수입니다.


                int x = player.getPosX(); // x는 현재 플레이어의 좌표값입니다.
                int y = player.getPosY(); // y는 현재 플레이어의 좌표값입니다.

                draw(imageD,350,50);       //똥 이미지 GUI 에 그려주기
                switch (e.getKeyCode()) {
                    case 37:        // 키값이 37(Left 화살표)이면 왼쪽으로 좌표 이동한 후 draw() 함수로 그려줍니다.
                        player.left();  // -5 좌표만큼 이동해주는 메서드 호출입니다.
                        draw(image, x, y);  // 그림 그려주는 메서드 호출입니다.
                        break;
                    case 39:        // 키값이 39(Right 화살표)이면 오른쪽으로 좌표 이동한 후 draw() 함수로 그려줍니다.
                        player.right(); // +5 좌표만큼 이동해주는 메서드 호출입니다.
                        draw(image, x, y);  // 그림 그려주는 메서드 호출입니다.
                        break;
                }


            }



            @Override
            public void keyReleased(KeyEvent e) {           //키보드를 누르고있을때
                System.out.println(e.getKeyCode());
            }
        });
    }

    public void draw(BufferedImage image, int x, int y) {       // 이미지 그려주는 메서드입니다.
        graphicDraw.drawImage(image,x,y,null);
    }

        public void clear() {       // 이전에 그렸던 그림을 지워주는 메서드입니다.
            graphicDraw.clearRect(player.getPosX(),player.getPosY(),32,32); //clearRect 설정한 좌표, 크기만큼 그림을 지워주는 함수
    }

    public void shitPerSecFall() {
        for (int i = 0; i < 100; i++) {
            try {
                shit.falling();             // 추가링!!!!
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
