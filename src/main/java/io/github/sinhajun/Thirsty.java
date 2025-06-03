package io.github.sinhajun;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

public class Thirsty {
    private int value = 20;

    public void sendActionBarPlayer(Player player) {
        Component message = Component.text()
                .content(String.valueOf(value))
                .color(NamedTextColor.AQUA)
                .asComponent();

        player.sendActionBar(message);
    }

    public int getValue() {
        return value;
    }
}
