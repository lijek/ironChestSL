package net.glasslauncher.ironchest.listeners;

import net.glasslauncher.ironchest.BlockMaterialChest;
import net.glasslauncher.ironchest.IronChestMod;
import net.minecraft.block.BlockBase;
import net.modificationstation.stationloader.api.common.config.Category;
import net.modificationstation.stationloader.api.common.event.block.BlockRegister;

public class BlockListener implements BlockRegister {

	public static Category blockIDS;
	public static BlockBase materialChest;
	
	@Override
	public void registerBlocks() {
		blockIDS = IronChestMod.config.getCategory("blocks");
		materialChest = new BlockMaterialChest(blockIDS.getProperty("materialChest", 200).getIntValue()).setName("ironchest:materialchest");
		IronChestMod.config.save();
	}

}
