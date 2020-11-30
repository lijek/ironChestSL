package net.glasslauncher.ironchest;

import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.inventory.InventoryBase;
import org.lwjgl.opengl.GL11;

import net.glasslauncher.ironchest.listeners.TextureListener;
import net.minecraft.entity.player.PlayerInventory;

public class GuiDiamondChest extends ContainerBase {

	private InventoryBase upperChestInventory;

	private InventoryBase lowerChestInventory;

	private int inventoryRows = 0;
	public TileEntityDiamondChest tileentity;

	public GuiDiamondChest(PlayerInventory inventoryplayer, TileEntityDiamondChest tileentitydiamondchest) {
		super((net.minecraft.container.ContainerBase) new ContainerDiamondChest(inventoryplayer,
				tileentitydiamondchest));
		this.tileentity = tileentitydiamondchest;
		this.containerWidth = 238;
		this.containerHeight = 256;
		this.passEvents = false;
	}



	protected void renderContainerBackground(float var1) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		minecraft.textureManager.bindTexture(minecraft.textureManager.getTextureId("/assets/ironchest/textures/diamondcontainer.png"));
		int i = (this.width - this.containerWidth) / 2;
		int j = (this.height - this.containerHeight) / 2;
		blit(i, j, 0, 0, this.containerWidth, this.containerHeight);
	}

}
