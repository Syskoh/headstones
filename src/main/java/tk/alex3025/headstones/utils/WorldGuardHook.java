package tk.alex3025.headstones.utils;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.entity.Player;

public class WorldGuardHook {

    public static StateFlag HEADSTONES_FLAG;

    public static void init() {
        HEADSTONES_FLAG = new StateFlag("headstones", false);
        WorldGuard.getInstance().getFlagRegistry().register(HEADSTONES_FLAG);
    }

    public static boolean queryFlag(Player player){
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        RegionContainer query = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery regionQuery = query.createQuery();

        ApplicableRegionSet set = regionQuery.getApplicableRegions(localPlayer.getLocation());

        return set.queryValue(localPlayer, HEADSTONES_FLAG) != null;
    }

}
