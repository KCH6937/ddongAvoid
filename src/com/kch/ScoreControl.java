package com.kch;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ScoreControl extends JFrame{

    private int score;
    private Font font = new Font("돋움", Font.PLAIN, 30);
    private JFrame jf = new JFrame();

    public ScoreControl() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int count){
        score = count;
    }

    public void saveScore(int count) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {

            fw = new FileWriter("Score.txt");
            bw = new BufferedWriter(fw);
            bw.write(count);

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                fw.close();
                bw.close();
            } catch (Exception e) {
            }
        }
    }

    public void fetchScore(){

    }

    public void scoreRender(){
       JLabel jLabel = new JLabel("점수 : " + score);
       jLabel.setFont(font);
       jf.add(jLabel);
       jf.setVisible(true);
       repaint();       // awt 안에 구현되어있기 때문에 Frame을 상속받으면 바로 사용가능 -lsh-
    }
<<<<<<< HEAD
}

//package com.kch;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//
//public class ScoreControl extends JFrame{
//    private int score;
//    private Font font = new Font("돋움", Font.PLAIN, 30);
//    private JFrame jf = new JFrame();
//
//
//    public ScoreControl() {
//        score = 0;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int count){
//        score = count;
//    }
//
//    public void saveScore(int count) {
//        FileWriter fw = null;
//        BufferedWriter bw = null;
//
//        try {
//
//            fw = new FileWriter("Score.txt");
//            bw = new BufferedWriter(fw);
//            bw.write(count);
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        } finally {
//            try {
//                fw.close();
//                bw.close();
//            } catch (Exception e) {
//            }
//        }
//    }
//
//    public void fetchScore(){
//
//    }
//
//    public void scoreRender(){
//       JLabel jLabel = new JLabel("점수 : " + score);
//       jLabel.setFont(font);
//       jf.add(jLabel);
//       jf.setVisible(true);
//       repaint();
//    }
//}
=======

}
>>>>>>> 79a67a86496d349fe88680ce2fa06cd0437e6e8b
