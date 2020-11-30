package net.glasslauncher.ironchest;

import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.InventoryBase;

import java.awt.*;

public class ContainerGoldChest extends ContainerBase {

	private final TileEntityGoldChest tileentity;
	private final int numRows;
	private final InventoryBase lowerChestInventory;

	public ContainerGoldChest(PlayerInventory inventoryplayer, TileEntityGoldChest tileentitygoldchest) {
		this.tileentity = tileentitygoldchest;
		this.numRows = tileentitygoldchest.getInventorySize() / 9;
		this.lowerChestInventory = tileentitygoldchest;
		for (int i = 0; i < 9; i++) {
			for (int l = 0; l < 9; l++)
				addSlot(new Slot(tileentitygoldchest, l + i * 9, 12 + l * 18, 8 + i * 18));
		}
		for (int j = 0; j < 3; j++) {
			for (int i1 = 0; i1 < 9; i1++)
				addSlot(new Slot((InventoryBase) inventoryplayer, i1 + j * 9 + 9, 12 + i1 * 18, 174 + j * 18));
		}
		for (int k = 0; k < 9; k++)
			addSlot(new Slot((InventoryBase) inventoryplayer, k, 12 + k * 18, 232));
	}

	public int guiInventorySize() {
		return 81;
	}
	
	public boolean canUse(PlayerBase player) {
		return lowerChestInventory.canPlayerUse(player);
	}

}
