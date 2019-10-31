package com.kch.entity;

import com.kch.entity.abstractionInterface.DirectionKey;
import javax.swing.*;

// 플레이어(사람) 클래스
public class Player extends JFrame implements DirectionKey {
    private int posX;
    private int posY;       // 나중에 final 써서 위치값 고정
    private float speed;
    private float gasokdo;
    private boolean status; // false 이면 죽음, true 이면 살아있음

    public Player(int posX, int posY, float speed, float gasokdo) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.gasokdo = gasokdo;
        this.status = true;
    }

    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void left() {
        setPosY(getPosX() - 1);
    }

    @Override
    public void right() {
        setPosX(getPosX() + 1);
    }

    public void deadStatus(int status) {    // 죽었을때 상태, 기능 추가하세욥
        setStatus(false);
    }

}
