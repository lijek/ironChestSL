package net.glasslauncher.ironchest;

import net.minecraft.client.gui.screen.container.ContainerBase;
import net.minecraft.inventory.InventoryBase;
import net.modificationstation.stationloader.api.common.gui.GuiHelper;
import org.lwjgl.opengl.GL11;

import net.glasslauncher.ironchest.listeners.TextureListener;
import net.minecraft.entity.player.PlayerInventory;

public class GuiGoldChest extends ContainerBase {

	private InventoryBase upperChestInventory;

	private InventoryBase lowerChestInventory;

	private int inventoryRows = 0;

	public TileEntityGoldChest tileentity;
	
	public GuiGoldChest(PlayerInventory inventoryplayer, TileEntityGoldChest tileentitygoldchest) {
		super((net.minecraft.container.ContainerBase) new ContainerGoldChest(inventoryplayer, tileentitygoldchest));
		this.tileentity = tileentitygoldchest;
		this.containerWidth = 184;
		this.containerHeight = 256;
		this.passEvents = false;
	}

	//protected void renderForeground(){}
	
	protected void renderContainerBackground(float var1) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		minecraft.textureManager.bindTexture(minecraft.textureManager.getTextureId("/assets/ironchest/textures/goldcontainer.png"));
		int i = (this.width - this.containerWidth) / 2;
		int j = (this.height - this.containerHeight) / 2;
		blit(i, j, 0, 0, this.containerWidth, this.containerHeight);
	}

}
