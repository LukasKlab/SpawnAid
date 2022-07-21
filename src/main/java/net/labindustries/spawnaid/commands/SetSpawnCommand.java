package net.labindustries.spawnaid.commands;

import net.labindustries.spawnaid.SpawnAid;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.swing.plaf.IconUIResource;


public class SetSpawnCommand implements CommandExecutor {

    private final SpawnAid spawnAid;

    public SetSpawnCommand(SpawnAid spawnAid) {
        this.spawnAid = spawnAid;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            Location location = player.getLocation();

            spawnAid.getConfig().set("spawn", location);
            //save the config.yml
            spawnAid.saveConfig();

            player.sendMessage("Spawn location set!");

        }else{
            System.out.println("You need to be a player to execute this command");
        }

        return true;


    }
}
