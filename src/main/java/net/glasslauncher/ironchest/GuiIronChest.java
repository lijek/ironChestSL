package net.glasslauncher.ironchest;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.InventoryBase;
import net.modificationstation.stationloader.api.common.packet.CustomData;

public class GuiIronChest extends ContainerBase{
	private InventoryBase upperChestInventory;

	private InventoryBase lowerChestInventory;

	private int inventoryRows = 0;

	public TileEntityIronChest tileentity;
	
	public GuiIronChest(PlayerInventory inventoryplayer, TileEntityIronChest tileentityironchest) {
		super((net.minecraft.container.ContainerBase) new ContainerIronChest(inventoryplayer, tileentityironchest));
		this.upperChestInventory = (InventoryBase) inventoryplayer;
		this.lowerChestInventory = tileentityironchest;
		this.passEvents = false;
		short var3 = 222;
		int var4 = var3 - 108;
		this.inventoryRows = tileentityironchest.getInventorySize() / 9;
		this.containerHeight = var4 + this.inventoryRows * 18;
		this.tileentity = tileentityironchest;
	}

	protected void renderForeground() {
		this.textManager.drawText(this.lowerChestInventory.getContainerName(), 8, 6, 4210752);
		this.textManager.drawText(this.upperChestInventory.getContainerName(), 8, this.containerHeight - 96 + 2, 4210752);
	}

	protected void renderContainerBackground(float var1) {
		int var2 = this.minecraft.textureManager.getTextureId("/gui/container.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.textureManager.bindTexture(var2);
		int var3 = (this.width - this.containerWidth) / 2;
		int var4 = (this.height - this.containerHeight) / 2;
		blit(var3, var4, 0, 0, this.containerWidth, this.inventoryRows * 18 + 17);
		blit(var3, var4 + this.inventoryRows * 18 + 17, 0, 126, this.containerWidth, 96);
	}
}
