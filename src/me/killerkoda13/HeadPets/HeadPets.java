package me.killerkoda13.HeadPets;

import net.minecraft.server.v1_11_R1.AttributeInstance;
import net.minecraft.server.v1_11_R1.EntityInsentient;
import net.minecraft.server.v1_11_R1.GenericAttributes;
import net.minecraft.server.v1_11_R1.PathEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftEntity;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Level;

/**
 * Created by killerkoda13 on 11/28/2016.
 */
public class HeadPets extends JavaPlugin {

    public static Player p;

    static Plugin plugin;


    public void followPlayer(Player player, LivingEntity entity, double d) {
        final LivingEntity e = entity;
        final Player p = player;
        final float f = (float) d;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if(e.getLocation().distance(p.getLocation()) > 15)
                {
                    e.teleport(p);
                }
                ((EntityInsentient) ((CraftEntity) e).getHandle()).getNavigation().a(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), f);
            }
        }, 0 * 20, 2 * 20);
    }


    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable()
    {

        plugin = this;
        Bukkit.getLogger().log(Level.INFO, "HeadPets has been enabled.");
        getServer().getPluginManager().registerEvents(new Events(), this);

    }

    @Override
    public void onDisable()
    {
        Bukkit.getLogger().log(Level.INFO, "HeadPets has been disabled.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = null;
        if (sender instanceof Player) {
            p = (Player) sender;
        } else {
            Bukkit.getLogger().log(Level.INFO, "Cannot run this command from console");
        }

        if (cmd.getName().equalsIgnoreCase("headpets")) {
            this.p = p;
            Pig entity = (Pig) HeadPets.p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
            followPlayer(p,entity,1);

        }
        return true;
    }
}
