package net.glasslauncher.ironchest;

import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.InventoryBase;

public class ContainerIronChest extends ContainerBase /* TODO ContainerIC2 */ {

	protected InventoryBase lowerChestInventory;

	public TileEntityIronChest tileentity;

	protected int numRows;
	
	public ContainerIronChest() {}

	public ContainerIronChest(PlayerInventory inventoryplayer, TileEntityIronChest tileentityironchest) {
		this.tileentity = tileentityironchest;
		this.lowerChestInventory = tileentityironchest;
		this.numRows = tileentityironchest.getInventorySize() / 9;
		int var3 = (this.numRows - 4) * 18;
		int var4;
		for (var4 = 0; var4 < this.numRows; var4++) {
			for (int var5 = 0; var5 < 9; var5++)
				addSlot(new Slot(tileentityironchest, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18));
		}
		for (var4 = 0; var4 < 3; var4++) {
			for (int var5 = 0; var5 < 9; var5++)
				addSlot(new Slot((InventoryBase) inventoryplayer, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
		}
		for (var4 = 0; var4 < 9; var4++)
			addSlot(new Slot((InventoryBase) inventoryplayer, var4, 8 + var4 * 18, 161 + var3));
	}

	public int guiInventorySize() {
		return 54;
	}

	/*public int getInput() { TODO IC2 ContainerIC2
		return firstEmptyFrom(0, guiInventorySize() - 1, this.tileentity);
	}*/

	public boolean canUse(PlayerBase entityplayer) {
		return this.lowerChestInventory.canPlayerUse(entityplayer);
	}

	public boolean canInteractWith(PlayerBase entityplayer) {
		return this.lowerChestInventory.canPlayerUse(entityplayer);
	}
}
