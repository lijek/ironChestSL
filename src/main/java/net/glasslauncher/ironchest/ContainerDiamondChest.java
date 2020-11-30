package net.glasslauncher.ironchest;

import net.minecraft.container.ContainerBase;
import net.minecraft.container.slot.Slot;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;

public class ContainerDiamondChest extends ContainerBase {
	private InventoryBase lowerChestInventory;

	private int numRows;

	public TileEntityDiamondChest tileentity;

	public ContainerDiamondChest(PlayerInventory inventoryplayer, TileEntityDiamondChest tileentitydiamondchest) {
		this.tileentity = tileentitydiamondchest;
		this.lowerChestInventory = tileentitydiamondchest;
		this.numRows = tileentitydiamondchest.getInventorySize() / 9;
		int var3 = (this.numRows - 4) * 18;
		for (int i = 0; i < 9; i++) {
			for (int l = 0; l < 12; l++)
				addSlot(new Slot(tileentitydiamondchest, l + i * 12, 12 + l * 18, 8 + i * 18));
		}
		for (int j = 0; j < 3; j++) {
			for (int i1 = 0; i1 < 9; i1++)
				addSlot(new Slot(inventoryplayer, i1 + j * 9 + 9, 39 + i1 * 18, 174 + j * 18));
		}
		for (int k = 0; k < 9; k++)
			addSlot(new Slot(inventoryplayer, k, 39 + k * 18, 232));
	}

	public int guiInventorySize() {
		return 108;
	}

	/*public void transferToSlots(ItemInstance itemstack, int i, int j, boolean flag) {
		a(itemstack, i, j, flag);
	}*/

	/*public int getInput() {
		return firstEmptyFrom(0, guiInventorySize() - 1, this.tileentity);
	}*/

	public void a(int i, int j) {}

	public boolean canUse(PlayerBase entityplayer) {
		return this.lowerChestInventory.canPlayerUse(entityplayer);
	}
}
