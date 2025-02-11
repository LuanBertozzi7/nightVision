package LuanBertozzi.nightVision.NightCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) { // verifica se quem usou o comando é um player
            Player player = (Player) sender;
            // verifica se o jogador tem permissão para usar o comando
            if (!player.hasPermission("nightvision.use")) {
                player.sendMessage("&4&lVocê não tem permissão para usar este comando!");
                return false;
            }
            //Se o jogador já tem a visão noturna, desativa
            if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage("Visão noturna removida!");
            } else {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 1,false, false, false));
                player.sendMessage("Visão noturna ativada!");
            }
        }
        return true;
    }

}