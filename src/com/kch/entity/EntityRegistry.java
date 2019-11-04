package com.kch.entity;

import com.kch.Main;
import com.kch.entity.abstractionInterface.Entity;

import java.util.*;

public class EntityRegistry {   // 똥 불러오고, 플레이어 불러오고, 똥 생성하고, 충돌체크



    private static Set<Shit> shits = new HashSet<>();       //생성
    private static Player player;
    private static Queue<Shit> removeQueue = new LinkedList<>();
    private static int MAX_SHIT_AMOUNT = 15;



    public static void registerPlayer(Player player) {
        EntityRegistry.player = player;         // 플레이어 등록해주는 함수
    }

    public static Player getPlayer() {
        return EntityRegistry.player;       // EntityRegistry의 player를 반환하는 함수
    }

    public static void createShit() {

        if(shits.size() <= MAX_SHIT_AMOUNT) {
            for(int i = 0; i < MAX_SHIT_AMOUNT/2; i++) {
                Shit shit = new Shit((int) (Math.random() * Main.SCREEN_WIDTH), 0,  (int) (Math.random() * 8));
                shits.add(shit);
            }
        }

    }

    public static void removeShit(Shit shit) {
        removeQueue.add(shit);
    }

    public static void dispose() {
        while(!removeQueue.isEmpty()) {
            Shit shit = removeQueue.poll();
            shits.remove(shit);
        }

        System.out.println(removeQueue.size());
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