package com.jaxzin.spigotmc.ping;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        this.getCommand("ping").setExecutor(new PingCommand());
    }

    @Override
    public void onDisable(){
        //Fired when the server enables the plugin
    }
}