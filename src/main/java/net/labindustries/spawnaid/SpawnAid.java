package net.labindustries.spawnaid;

import net.labindustries.spawnaid.commands.SetSpawnCommand;
import net.labindustries.spawnaid.commands.SpawnCommand;
import net.labindustries.spawnaid.events.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnAid extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
