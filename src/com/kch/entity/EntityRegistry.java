package com.kch.entity;

import com.kch.Main;
import com.kch.entity.abstractionInterface.Entity;

import java.util.HashSet;
import java.util.Set;

public class EntityRegistry {   // 똥 불러오고, 플레이어 불러오고, 똥 생성하고, 충돌체크

    private static Set<Shit> shits = new HashSet<>();
    private static Player player;

    public static void registerPlayer(Player player) {
        EntityRegistry.player = player;
    }

    public static Player getPlayer() {
        return EntityRegistry.player;
    }

    public static void createShit() {
        Shit shit = new Shit((int)Math.random() * Main.SCREEN_WIDTH, 0, (int)Math.random() * 20);
        shits.add(shit);
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