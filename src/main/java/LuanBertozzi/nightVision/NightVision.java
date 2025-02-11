package LuanBertozzi.nightVision;

import org.bukkit.plugin.java.JavaPlugin;

public final class NightVision extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("-----------||-----------------");
        getLogger().info("| Night Vision (LuanBertozzi7) |");
        getLogger().info("-----------||-----------------");
        getCommand("nightvision").setExecutor(new NightVisionCommand());
        getServer().getPluginManager().registerEvents(new NightVisionAutoEnabled(this), this);
    }
    @Override
    public void onDisable() {
    }
}