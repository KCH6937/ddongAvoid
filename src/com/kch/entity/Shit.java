package com.kch.entity;

import com.kch.entity.abstractionInterface.DirectionKey;

//  똥 클래스
/**
 * @author 이상훈
 * @since 2019-10-31
 * */
public class Shit implements DirectionKey {

    private int posX;                               //변수 생성
    private int posY;
    private float speed;

   public Shit(int posX, int posY, float speed ){           //플레이어와 마찬가지로 생성
       this.posX = posX;
       this.posY = posY;
       this.speed = speed;
   }

   /**
    * 똥의 y값을 1 증가시키는 메소드임 개꿀 ㅈㅅ
    * */
    public void falling() {
        posY = posY++;
                                    //떨어지는 함수 위에서 1씩 증가시킴(0~~850)
    }                              //x y 그래프라고 생각하면 안됨! 왼쪽상단 모서리가  "0"

    @Override                       //이거 아래로 무시하면됨(그렇다고 지우면 안됨)
    public void left() {

    }

    @Override
    public void right() {

    }
}
