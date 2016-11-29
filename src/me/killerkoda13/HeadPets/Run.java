package me.killerkoda13.HeadPets;

import org.bukkit.Location;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Squid;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by killerkoda13 on 11/28/2016.
 */
public class Run extends BukkitRunnable{

    public Plugin pl;
    public long delay;
    public Slime s;

    public Run(Plugin plugin, long delay, Slime squid)
    {

    }

    @Override
    public void run() {
            Location p = HeadPets.p.getLocation();
            Location l = Events.entity.getLocation();

            this.s.setGravity(false);
            p.setX(p.getX()+4);
            this.s.teleport(p);
    }
}
