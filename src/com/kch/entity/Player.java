package com.kch.entity;

import com.kch.entity.abstractionInterface.DirectionKey;
import com.kch.entity.abstractionInterface.ImageProvider;
import com.kch.storage.FileStorage;

import javax.swing.*;
import java.awt.image.BufferedImage;

// 플레이어(사람) 클래스
public class Player implements DirectionKey, ImageProvider {
    private int posX;
    private int posY;       // 나중에 final 써서 위치값 고정해주세요
    private float speed;
    private float gasokdo;
    private boolean status; // false 이면 죽음, true 이면 살아있습니다.

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
    public void left() {setPosX(getPosX() - 5); }       //굿 b - lsh






    @Override
    public void right() { setPosX(getPosX() + 5); }




    public void deadStatus(boolean status) {    // 죽었을때 상태, 기능 추가하세욥
        setStatus(status);
    }

    @Override
    public BufferedImage getImage() {
        return FileStorage.bufferedImageMap.get("사람");
    }   // 이미지 가져오는 메서드입니다.
}
