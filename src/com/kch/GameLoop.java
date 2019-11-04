package com.kch;

import com.kch.entity.EntityRegistry;
import com.kch.entity.Player;
import com.kch.entity.Shit;
import com.kch.entity.abstractionInterface.Entity;


import java.util.Set;

public class GameLoop {
    private Player player = EntityRegistry.getPlayer();

    public void rendar(){
        EntityRegistry.getShits().forEach(shit -> {
            Main.gui.draw(shit.getImage(), shit.getPosX(), shit.getPosY());

        });

        Main.gui.draw(player.getImage(), player.getPosX(), player.getPosY());

    }

    public boolean run(){
        EntityRegistry.createShit();
        Set<Shit> shits = EntityRegistry.getShits();
        shits.forEach(i -> i.falling());
        boolean success = false;

        if (EntityRegistry.isCollision()){
            success = false;
        }else{
            rendar();
            success = true;
        }

        EntityRegistry.dispose();
        return success;
    }
}
