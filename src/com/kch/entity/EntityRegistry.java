package com.kch.entity;

import com.kch.Main;
import com.kch.entity.abstractionInterface.Entity;

import java.util.*;

public class EntityRegistry {   // 똥 불러오고, 플레이어 불러오고, 똥 생성하고, 충돌체크

    private static Set<Shit> shits = new HashSet<>();
    private static Queue<Shit> removeQueue = new LinkedList<>();
    private static Player player;
    private static int MAX_SHIT_AMOUNT = 15;

    public static void registerPlayer(Player player) {
        EntityRegistry.player = player;
    }

    public static Player getPlayer() {
        return EntityRegistry.player;
    }

    public static void createShit() {
        if(shits.size() <= MAX_SHIT_AMOUNT) {
            for(int i = 0; i < MAX_SHIT_AMOUNT/2; i++) {
                Shit shit = new Shit((int) (Math.random() * Main.SCREEN_WIDTH), 0, (int) (Math.random() * 5));
                shits.add(shit);
            }
        };

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

        if(player != null) {
            for (Shit shit : shits) {
                bCollision = player.isCollision(shit);

                if (bCollision) {
                    break;
                }
            }
        }
        return bCollision;
    }

    public static Set<Shit> getShits() { return shits; }
}
