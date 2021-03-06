package com.kch;
import com.kch.entity.EntityRegistry;
import com.kch.entity.Player;
import com.kch.entity.Shit;
import com.kch.entity.abstractionInterface.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author 이상훈(kebin0613@github.com)
 * @since 2019-10-31
 *
 * */
//  gui 클래스
public class Gui extends JFrame {

    private Graphics2D graphicDraw;     //
    private int score = 0;
    private Font font = new Font("돋움", Font.PLAIN, 20);
    private JLabel jLabel = new JLabel("점수 : " + score, SwingConstants.LEFT);

    public Gui() {
        setTitle("똥피하기");       //게임 이름
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);    //전체게임창을 설정
        setResizable(false);    //한번 만들어진 게임창은 임의로 줄이지 못하게 함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //게임창을 종료했을때 프로그램 전체가 종료되게 함 (내부에서 안돌아가게하는거)
        setVisible(true);   //게임창이 정상적으로 출력하게 하는거
        setLocationRelativeTo(null);      //실행했을때 게임창이 모니터의 중간에 뜨게 함
        setPreferredSize(new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT));

        graphicDraw = (Graphics2D) getGraphics();   // getGraphics() 메서드의 반환형이 그냥 Graphics 이므로 Graphics2D 타입으로 명시적형변환(캐스팅)입니다.

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                //키보드를 눌렀을때
                Player player = EntityRegistry.getPlayer();
                BufferedImage image = player.getImage();
                clear();        // 이전에 그린 사람의 이미지를 지워주는 함수입니다.

                int x = player.getPosX(); // x는 현재 플레이어의 좌표값입니다.
                int y = player.getPosY(); // y는 현재 플레이어의 좌표값입니다.

                switch (e.getKeyCode()) {
                    case 37:        // 키값이 37(Left 화살표)이면 왼쪽으로 좌표 이동한 후 draw() 함수로 그려줍니다.
                        player.controlX(-10);  // -5 좌표만큼 이동해주는 메서드 호출입니다.
                        draw(image, x, y);  // 그림 그려주는 메서드 호출입니다.
                        break;
                    case 39:        // 키값이 39(Right 화살표)이면 오른쪽으로 좌표 이동한 후 draw() 함수로 그려줍니다.
                        player.controlX(+10); // +5 좌표만큼 이동해주는 메서드 호출입니다.
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
        Player player = EntityRegistry.getPlayer();     // 플레이어 EntityRegistry 클래스에 등록
        graphicDraw.clearRect(player.getPosX(),player.getPosY(),32,32); //clearRect 설정한 좌표, 크기만큼 그림을 지워주는 함수
    }

    public int getScore(){
        return score;
    }

    public void setScore(int count){
        score = count;
    }

    public void saveScore(){ //파일세이브
        FileWriter fw = null;
        BufferedWriter bw = null;

        try{
            fw = new FileWriter("Score.txt");
            bw = new BufferedWriter(fw);
            bw.write(score);
        }catch(Exception e){
            e.getStackTrace();
        }finally {
            try{
                fw.close();
                bw.close();
            }catch(Exception e){
                e.getStackTrace();
            }
        }
    }

    public void fetchScore(){
        try {
            File file = new File("./Score.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            br.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void scoreRender(){
        jLabel.setAlignmentX(10);
        jLabel.setAlignmentY(10);
        add(jLabel);
    }

}
