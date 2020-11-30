package net.glasslauncher.ironchest;

import net.minecraft.container.ContainerBase;
import net.minecraft.entity.player.PlayerInventory;

public interface IHasGuiContainer {
	public ContainerBase getGuiContainer(PlayerInventory inv);
}
