package io.github.sinhajun.plugin;

import io.github.sinhajun.ThirstyEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("Plugin enable");
        getServer().getPluginManager().registerEvents(new ThirstyEvent(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disable");
    }
}
