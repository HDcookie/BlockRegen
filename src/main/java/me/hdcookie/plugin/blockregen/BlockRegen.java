package me.hdcookie.plugin.blockregen;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class BlockRegen extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(this, this);

    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){

        if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
            if(event.getPlayer().getWorld().equals(Bukkit.getWorld(getConfig().getString("world"))))
                System.out.println("is world");

            Material mat = event.getBlock().getType();

            Bukkit.getScheduler().runTaskLater(this, () -> {
                System.out.println("runnable");

                event.getBlock().setType(mat);


            }, getConfig().getInt("time"));

        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
