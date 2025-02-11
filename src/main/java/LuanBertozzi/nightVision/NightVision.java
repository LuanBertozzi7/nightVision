package LuanBertozzi.nightVision;

import org.bukkit.plugin.java.JavaPlugin;

public final class NightVision extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("----------- / -----------------");
        getLogger().info("| &6&lNight Vision Plus Plugin &a&l|");
        getLogger().info("----------- / -----------------");
        getLogger().info(" Desenvolvido por LuanBertozzi");
        getLogger().info("----------- / -----------------");
        getCommand("nightvision").setExecutor(new NightVisionCommand());
        getServer().getPluginManager().registerEvents(new NightVisionAutoEnabled(this), this);

    }
    @Override
    public void onDisable() {
    }
}
// Luan