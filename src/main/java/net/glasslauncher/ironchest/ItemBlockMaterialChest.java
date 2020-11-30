package net.glasslauncher.ironchest;

import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;
import net.modificationstation.stationloader.api.common.preset.item.PlaceableTileEntityWithMetaAndName;

public class ItemBlockMaterialChest extends PlaceableTileEntity {

	public ItemBlockMaterialChest(int i) {
		super(i);
		setDurability(0);
		setHasSubItems(true);
	}

	public int getMetaData(int i) {
		return i;
	}

	public String getTranslationKey(ItemInstance item) {
		return getTranslationKey() + item.getDamage();
	}

}
