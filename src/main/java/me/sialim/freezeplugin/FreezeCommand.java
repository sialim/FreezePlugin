package me.sialim.freezeplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p){
            if(args.length==0){
                freezeLogic(p, p);
                p.sendMessage("Frozen: " + FreezeUtils.frozenList.contains(p));
            }else{
                Player t = Bukkit.getServer().getPlayerExact(args[0]);
                freezeLogic(p, t);
                p.sendMessage("Frozen: " + FreezeUtils.frozenList.contains(t));
            }
        }
        return true;
    }

    private void freezeLogic(Player p, Player t){ //First parameter is command executor, second parameter is who is being frozen
        if(p.hasPermission("freezeplugin.freeze")){
            if(t.isOnGround()){
                if(FreezeUtils.frozenList.contains(t)){
                    FreezeUtils.frozenList.remove(t);

                }else{
                    FreezeUtils.frozenList.add(t);
                }
            }else{
                p.sendMessage("Target must be on ground.");
            }
        }
    }
}
