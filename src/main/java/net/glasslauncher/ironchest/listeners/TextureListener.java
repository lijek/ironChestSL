package net.glasslauncher.ironchest.listeners;

import net.modificationstation.stationloader.api.client.event.texture.TextureRegister;
import net.modificationstation.stationloader.api.client.texture.TextureFactory;
import net.modificationstation.stationloader.api.client.texture.TextureRegistry;

public class TextureListener implements TextureRegister {

    public static int[] ironChest;
    public static int[] goldChest;
    public static int[] diamondChest;
    public static int[] obsidianChest;
    public static int goldContainer;
    public static int diamondContainer;

    private int getTextureID(String textureName) {
        return TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ironchest/textures/" + textureName);
    }

    private int getGuiTextureID(String textureName) {
        return TextureFactory.INSTANCE.addTexture(TextureRegistry.getRegistry("TERRAIN"), "/assets/ironchest/textures/" + textureName);
    }

    @Override
    public void registerTextures() {
        goldContainer = getGuiTextureID("goldcontainer.png");
        diamondContainer = getGuiTextureID("diamondcontainer.png");

        ironChest = new int[3];
        ironChest[0] = getTextureID("ironChestFront.png"); //43;
        ironChest[1] = getTextureID("ironChestSide.png"); //44;
        ironChest[2] = getTextureID("ironChestBottom.png"); //42;


        goldChest = new int[3];
        goldChest[0] = getTextureID("goldChestFront.png");
        goldChest[1] = getTextureID("goldChestSide.png");
        goldChest[2] = getTextureID("goldChestBottom.png");

        diamondChest = new int[3];
        diamondChest[0] = getTextureID("diamondChestFront.png");
        diamondChest[1] = getTextureID("diamondChestSide.png");
        diamondChest[2] = getTextureID("diamondChestBottom.png");

        obsidianChest = new int[3];
        obsidianChest[0] = getTextureID("obsidianChestFront.png");
        obsidianChest[1] = getTextureID("obsidianChestSide.png");
        obsidianChest[2] = getTextureID("obsidianChestBottom.png");
    }

}
