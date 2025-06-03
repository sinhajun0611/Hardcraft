package io.github.sinhajun;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

import static io.github.sinhajun.Condition.thirstyMap;
import static io.github.sinhajun.plugin.Plugin.plugin;

public class ThirstyEvent implements Listener {

    private final Map<Player, BukkitRunnable> runnableMap = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        BukkitRunnable bukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                if (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE) {
                    if (!thirstyMap.containsKey(player)) thirstyMap.put(player, new Thirsty());
                    Thirsty thirsty = thirstyMap.get(player);
                    thirsty.sendActionBarPlayer(player);
                }
            }
        };
        bukkitRunnable.runTaskTimer(plugin, 0L, 0L);
        runnableMap.put(player, bukkitRunnable);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        runnableMap.get(player).cancel();
    }

    // TODO : 나중에 지우시오
    private void sendLog(String message) {
        plugin.getLogger().info(message);
    }
}
