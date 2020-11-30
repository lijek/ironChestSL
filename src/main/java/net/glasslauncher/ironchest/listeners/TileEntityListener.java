package net.glasslauncher.ironchest.listeners;

import java.util.Map;

import net.glasslauncher.ironchest.TileEntityDiamondChest;
import net.glasslauncher.ironchest.TileEntityGoldChest;
import net.glasslauncher.ironchest.TileEntityIronChest;
import net.modificationstation.stationloader.api.common.event.block.TileEntityRegister;

public class TileEntityListener implements TileEntityRegister {

	public static TileEntityIronChest ironChestEntity;
	
	@Override
	public void registerTileEntities(Map<Class<?>, String> map) {
		map.put(TileEntityIronChest.class, "ironchest:tileEntityIronChest");
		map.put(TileEntityGoldChest.class, "ironchest:tileEntityGoldChest");
		map.put(TileEntityDiamondChest.class, "ironchest:tileEntityDiamondChest");
	}

}
