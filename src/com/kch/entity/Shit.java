package com.kch.entity;

import com.kch.entity.abstractionInterface.DirectionKey;
import com.kch.entity.abstractionInterface.ImageProvider;
import com.kch.storage.FileStorage;

import java.awt.image.BufferedImage;

//  똥 클래스
/**
 * @author 이상훈
 * @since 2019-10-31
 * */
public class Shit implements ImageProvider {

    private int posX;                               //변수 생성
    private int posY;
    private float speed;

   public Shit(int posX, int posY, float speed ){           //생성자
       this.posX = posX;
       this.posY = posY;
       this.speed = speed;
   }

   /**
    * 똥의 y값을 1 증가시키는 메소드임 개꿀><
    * */
    public void falling() {
        posY = posY+ 50;
                                    //떨어지는 함수 위에서 1씩 증가시킴(0~~850)
    }                              //x y 그래프라고 생각하면 안됨! 왼쪽상단 모서리가  "0"

                                  // left, right 는 필요없으나  DirectionKey 를 쓸때 써야함(그렇다고 지우면 안됨)
    @Override
    public BufferedImage getImage() {                   //BufferedImage 가 리턴형 임 getImage 함수 호출
        return FileStorage.bufferedImageMap.get("똥");       //리턴값 FileStorage(파일저장소)의 똥이미지
    }
}
