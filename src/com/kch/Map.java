package com.kch;
import java.awt.*;
//  맵 클래스
public class Map {
    private int posX;   // 맵 화면 위치 x값
    private int posY;   // 맵 화면 위치 y값
    private int mapWidth;   // 맵 너비
    private int mapHeight;  // 맵 높이
    private int mapLimitLeft;   // 맵 왼쪽한계값(나중에 플레이어의 왼쪽 좌표 한계값)
    private int mapLimitRight;  // 맵 오른쪽한계값(나중에 플레이어랑 오른쪽 좌표 한계값)

    public Map(int posX, int posY, int mapWith, int mapHeight) {
        this.posX = posX;
        this.posY = posY;
        this.mapHeight = mapHeight;
        this.mapWidth = mapWith;
        this.mapLimitLeft = 0;
        this.mapLimitRight = this.mapWidth;
    }

    public int getMapHeight() { return mapHeight; }
    public void setMapHeight(int mapHeight) { this.mapHeight = mapHeight; }
    public int getMapLimitLeft() { return mapLimitLeft; }
    public void setMapLimitLeft(int mapLimitLeft) { this.mapLimitLeft = mapLimitLeft; }
    public int getMapLimitRight() { return mapLimitRight; }
    public void setMapWidth(int mapWidth) { this.mapWidth = mapWidth; }
    public int getMapWidth() { return mapWidth; }
    public void setMapLimitRight(int mapLimitRight) { this.mapLimitRight = mapLimitRight; }
    public int getPosX() { return posX; }
    public void setPosX(int posX) { this.posX = posX; }
    public int getPosY() { return posY; }
    public void setPosY(int posY) { this.posY = posY; }

    // 맵 그려주는 함수
    public void callMap() {
        Frame f = new Frame();
        f.setTitle("똥 피하기");
        f.setVisible(true);
        f.setBounds(getPosX(),getPosY(),getMapWidth(),getMapHeight());
    }
}
