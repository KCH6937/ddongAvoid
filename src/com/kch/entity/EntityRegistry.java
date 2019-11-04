package com.kch.entity;

import com.kch.Main;
import com.kch.entity.abstractionInterface.Entity;

import java.util.HashSet;
import java.util.Set;

public class EntityRegistry {   // 똥 불러오고, 플레이어 불러오고, 똥 생성하고, 충돌체크


    private static Set<Shit> shits = new HashSet<>();       //생성
    private static Player player;

    private static Set<Shit> shits = new HashSet<>();       // shit 클래스 타입의 변수를 저장할 HashSet
    private static Player player;                           // Player 타입 변수 하나 선언


    public static void registerPlayer(Player player) {
        EntityRegistry.player = player;         // 플레이어 등록해주는 함수
    }

    public static Player getPlayer() {
        return EntityRegistry.player;       // EntityRegistry의 player를 반환하는 함수
    }

    public static void createShit() {
        Shit shit = new Shit((int)Math.random() * Main.SCREEN_WIDTH, 0, (int)Math.random() * 20);   // 랜덤으로 똥을 생성, 떨어지는 속도도 랜덤
        shits.add(shit);    // 해쉬셋에 똥을 추가해줌(아마 같은위치에 생길 수도 있어서 hashCode()는 써줘야되지 않을까 싶네요 저도 잘모르겠슴다..)
    }

    public static boolean isCollision() {
        boolean bCollision = false;

        if(player != null) {        // 플레이어가 화면에 없어도 똥을 생성항
            for (Shit shit : shits) {
                bCollision = player.isCollision(shit);      // 플레이어와 똥이 충돌했을 때의 값을 넣어줌 bCollision = true 면 종료

                if (bCollision) {
                    break;
                }
            }
        }
        return bCollision;  // 충돌값을 반환
    }

    public static Set<Shit> getShits() { return shits; }    // 해쉬셋을 반환
}