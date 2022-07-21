package net.labindustries.spawnaid.events;

import net.labindustries.spawnaid.SpawnAid;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnEvent implements Listener {

    private final SpawnAid spawnAid;

    public SpawnEvent(SpawnAid spawnAid) {
        this.spawnAid = spawnAid;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        //When a player joins for the first time, teleport them to the spawn if it is set
        if(!e.getPlayer().hasPlayedBefore()){
            Location location = spawnAid.getConfig().getLocation("spawn");
            if(location != null){
                //spawn them
                e.getPlayer().teleport(location);
            }
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerRespawnEvent e){
        //When the player dies, respawn them at the spawn location if set
        Location location = spawnAid.getConfig().getLocation("spawn");
        if(location != null){
            //spawn them
            e.setRespawnLocation(location);
        }
    }

}
