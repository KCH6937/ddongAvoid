package com.kch.entity;

import com.kch.entity.abstractionInterface.Entity;
import com.kch.storage.FileStorage;

import java.awt.*;
import java.awt.image.BufferedImage;

// 플레이어(사람) 클래스
public class Player extends Entity {

    private float speed;
    private float gasokdo;
    private boolean status; // false 이면 죽음, true 이면 살아있습니다.

    public Player(int posX, int posY, float speed, float gasokdo) {
        super(posX, posY);
        this.speed = speed;
        this.gasokdo = gasokdo;
        this.status = true;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void deadStatus(boolean status) {    // 죽었을때 상태, 기능 추가하세욥
        setStatus(status);
    }

    @Override
    public BufferedImage getImage() {
        return FileStorage.bufferedImageMap.get("사람");
    }   // 이미지 가져오는 메서드입니다.
}
