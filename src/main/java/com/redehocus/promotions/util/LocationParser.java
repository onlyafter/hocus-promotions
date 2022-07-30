package com.redehocus.promotions.util;

import com.google.common.collect.Maps;
import com.redehocus.promotions.PromotionsPlugin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Map;

@Getter
public class LocationParser {

    public static Map<String, Location> cachedLocationMap = Maps.newHashMap();

    public static void set(Location location, String name) {

        PromotionsPlugin.getInstance().getConfig().set(name, location.getX() + ":" + location.getY() + ":" + location.getZ() + ":" + location.getPitch() + ":" + location.getYaw() + ":" + location.getWorld().getName());
        PromotionsPlugin.getInstance().saveConfig();

    }

    public static Location get(String name) {

        Location cachedLocation = cachedLocationMap.get(name);

        if(cachedLocation == null) {
            double x = Double.parseDouble(PromotionsPlugin.getInstance().getConfig().getString(name).split(":")[0]);
            double y = Double.parseDouble(PromotionsPlugin.getInstance().getConfig().getString(name).split(":")[1]);
            double z = Double.parseDouble(PromotionsPlugin.getInstance().getConfig().getString(name).split(":")[2]);

            float pitch = Float.parseFloat(PromotionsPlugin.getInstance().getConfig().getString(name).split(":")[3]);
            float yaw = Float.parseFloat(PromotionsPlugin.getInstance().getConfig().getString(name).split(":")[4]);

            World world = Bukkit.getServer().getWorld(PromotionsPlugin.getInstance().getConfig().getString(name).split(":")[5]);

            return new Location(world, x, y, z, yaw, pitch);

        }

        return cachedLocation;

    }

    public static Boolean contains(String name) {
        if (cachedLocationMap.containsKey(name)) return true;
        return PromotionsPlugin.getInstance().getConfig().contains(name);

    }

}