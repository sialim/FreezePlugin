package me.sialim.freezeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class FreezePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("freeze").setExecutor(new FreezeCommand());
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
    }

    public void onDisable(){
        FreezeUtils.frozenList.clear();
    }
}
