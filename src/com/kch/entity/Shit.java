package com.kch.entity;

import com.kch.entity.abstractionInterface.Entity;
import com.kch.storage.FileStorage;

import java.awt.image.BufferedImage;

//  똥 클래스
/**
 * @author 이상훈
 * @since 2019-10-31
 * */
public class Shit extends Entity  {

    private float speed;

   public Shit(int posX, int posY, float speed ){      //생성자
       super(posX, posY);

       this.speed = speed;
   }

   /**
    * 똥의 y값을 1 증가시키는 메소드임 개꿀><
    * x y 그래프라고 생각하면 안됨! 왼쪽상단 모서리가  "0"
    * 떨어지는 함수 위에서 1씩 증가시킴(0~~850)
    * */
    public void falling() {
        controlY((int) (+1 * speed));       //
    }

    @Override
    public BufferedImage getImage() {                   //BufferedImage 가 리턴형 임 getImage 함수 호출
        return FileStorage.bufferedImageMap.get("똥");       //리턴값 FileStorage(파일저장소)의 똥이미지
    }
}
