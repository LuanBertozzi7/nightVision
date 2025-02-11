package LuanBertozzi.nightVision;

import org.bukkit.event.Listener;
import org.bukkit.*;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionAutoEnabled implements Listener {
    private final NightVision plugin;

    public NightVisionAutoEnabled(NightVision plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            return; // Evitar que o plugin ative a jogadores no modo criativo ou espectador
        }

        Location loc = player.getLocation();
        World world = loc.getWorld();

        int LightLevel = 0;
        if (world != null) {
            LightLevel = world.getBlockAt(loc).getLightLevel();
        }
        if (LightLevel < 7) {
            if (!player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1));
                world.spawnParticle(Particle.RAIN, loc.add(0, 1, 0), 30, 0.5, 0.5, 0.5, 0.1);
            }
        } else {
            if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                world.spawnParticle(Particle.RAIN, loc.add(0, 1, 0), 30, 0.5, 0.5, 0.5, 0.1);
            }
        }
    }
}
//Luan