package net.labindustries.spawnaid.commands;

import net.labindustries.spawnaid.SpawnAid;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpawnCommand implements @Nullable CommandExecutor {

  private final SpawnAid spawnAid;

  public SpawnCommand(SpawnAid spawnAid) {
    this.spawnAid = spawnAid;
  }

  @Override
  public boolean onCommand(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      @NotNull String[] args) {

    if (sender instanceof Player) {
      Player player = (Player) sender;

      Location location = spawnAid.getConfig().getLocation("spawn");
      if (location != null) {
        player.teleport(location);
      } else {
        player.sendMessage("There is currently no spawn-point.");
      }

    } else {
      System.out.println("You need to be a player to execute this command");
    }

    return true;
  }
}
