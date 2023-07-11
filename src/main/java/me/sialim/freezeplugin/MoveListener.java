package me.sialim.freezeplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        e.setCancelled(FreezeUtils.frozenList.contains(p));
    }
}
