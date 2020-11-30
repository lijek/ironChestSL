package net.glasslauncher.ironchest;

import net.fabricmc.loader.api.FabricLoader;
import net.glasslauncher.ironchest.listeners.BlockListener;
import net.glasslauncher.ironchest.listeners.TextureListener;
import net.glasslauncher.ironchest.listeners.TileEntityListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.container.ContainerBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.modificationstation.stationloader.api.client.event.texture.TextureRegister;
import net.modificationstation.stationloader.api.common.config.Configuration;
import net.modificationstation.stationloader.api.common.event.block.BlockRegister;
import net.modificationstation.stationloader.api.common.event.block.TileEntityRegister;
import net.modificationstation.stationloader.api.common.event.recipe.RecipeRegister;
import net.modificationstation.stationloader.api.common.gui.GuiHelper;
import net.modificationstation.stationloader.api.common.mod.StationMod;

public class IronChestMod implements StationMod {

	public static Configuration config;

	@Override
	public void preInit() {
		config = getDefaultConfig();
		config.load();
		
		TextureRegister.EVENT.register(new TextureListener());
		BlockRegister.EVENT.register(new BlockListener());
		TileEntityRegister.EVENT.register(new TileEntityListener());
	}

	public static void openGui(ScreenBase gui) {
		((Minecraft) FabricLoader.getInstance().getGameInstance()).openScreen(gui);
	}

	/*public static void openGui(PlayerBase entityplayer, int id, InventoryBase inventory, ContainerBase container) {
		GuiHelper.INSTANCE.openGUI(entityplayer, "ironchest", (short) id, inventory, container);
	}*/

	public static PlayerBase getPlayer() {
		return ((Minecraft) FabricLoader.getInstance().getGameInstance()).player;
	}
}
