package net.glasslauncher.ironchest;

import net.minecraft.container.ContainerBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.util.io.AbstractTag;
import net.minecraft.util.io.CompoundTag;
import net.minecraft.util.io.ListTag;

public class TileEntityDiamondChest extends TileEntityBlock implements InventoryBase {
	private ItemInstance[] chestContents = new ItemInstance[113];

	public static ItemBase[] repairItemArray = new ItemBase[48];

	public String tmpName = "Diamond Chest";

	public PlayerBase player = null;

	public int getInventorySize() {
		return 108;
	}

	public ItemInstance getInventoryItem(int var1) {
		return this.chestContents[var1];
	}

	public ItemInstance takeInventoryItem(int var1, int var2) {
		if (this.chestContents[var1] != null) {
			if ((this.chestContents[var1]).count <= var2) {
				ItemInstance ItemInstance1 = this.chestContents[var1];
				this.chestContents[var1] = null;
				return ItemInstance1;
			}
			ItemInstance var3 = this.chestContents[var1].split(var2);
			if ((this.chestContents[var1]).count == 0)
				this.chestContents[var1] = null;
			return var3;
		}
		return null;
	}

	public void setInventoryItem(int var1, ItemInstance var2) {
		this.chestContents[var1] = var2;
		if (var2 != null && var2.count > getMaxItemCount())
			var2.count = getMaxItemCount();
	}

	public void setTmpName(String var1) {
		this.tmpName = var1;
	}

	public String getContainerName() {
		return this.tmpName;
	}

	public void readIdentifyingData(CompoundTag var1) {
		super.readIdentifyingData(var1);
		ListTag var2 = var1.getListTag("Items");
		this.chestContents = new ItemInstance[getInventorySize()];
		for (int var3 = 0; var3 < var2.size(); var3++) {
			CompoundTag var4 = (CompoundTag) var2.get(var3);
			int var5 = var4.getByte("Slot") & 0xFF;
			if (var5 >= 0 && var5 < this.chestContents.length)
				this.chestContents[var5] = new ItemInstance(var4);
		}
	}

	public void writeIdentifyingData(CompoundTag var1) {
		super.writeIdentifyingData(var1);
		ListTag var2 = new ListTag();
		for (int var3 = 0; var3 < this.chestContents.length; var3++) {
			if (this.chestContents[var3] != null) {
				CompoundTag var4 = new CompoundTag();
				var4.put("Slot", (byte) var3);
				this.chestContents[var3].toTag(var4);
				var2.add((AbstractTag) var4);
			}
		}
		var1.put("Items", (AbstractTag) var2);
	}

	public int getMaxItemCount() {
		return 64;
	}

	public boolean canPlayerUse(PlayerBase var1) {
		return (this.level.getTileEntity(this.x, this.y, this.z) != this) ? false
				: ((var1.squaredDistanceTo(this.x + 0.5D, this.y + 0.5D, this.z + 0.5D) <= 64.0D));
	}

	public ContainerBase getGuiContainer(PlayerInventory inv) {
		return (ContainerBase) new ContainerDiamondChest(inv, this);
	}
}
