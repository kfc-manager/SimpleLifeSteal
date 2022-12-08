package kalle.com.simplelifesteal.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player killed = (Player) event.getEntity();
        if (!(killed.getKiller() instanceof Player)) {
            return;
        }
        Player killer = killed.getKiller();
        killer.setMaxHealth(killer.getMaxHealth() + 2.0);
        if (killed.getMaxHealth() <= 2.0) {
            return;
        }
        killed.setMaxHealth(killed.getMaxHealth() - 2.0);
    }

}
