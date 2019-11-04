package com.kch.entity.abstractionInterface;

import java.awt.*;

/**
 * @author 남대영
 * @since 2019 11 02
 *
 * Player, Shit의 부모 클래스
 * */
public abstract class Entity implements ImageProvider, PhysicsObject {

    private int posX, posY;

    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() { return posX; }
    public int getPosY() { return posY; }

    /**
     * X좌표값을 변경합니다.
     * */
    public void controlX(int control) {
        this.posX += control;
    }

    /**
     * Y좌표값을 변경합니다.
     * */
    public void controlY(int control) {
        this.posY += control;
    }

    @Override
    public boolean isCollision(Entity entity) {
        Rectangle targetRectangle = new Rectangle(entity.getPosX(), entity.getPosY(), 8, 8);
        Rectangle rect = new Rectangle(getPosX(), getPosY(), 32, 32);

        return rect.intersects(targetRectangle);
    }


}
