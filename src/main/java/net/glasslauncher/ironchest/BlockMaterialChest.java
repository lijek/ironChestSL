package net.glasslauncher.ironchest;

import net.glasslauncher.ironchest.listeners.TextureListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.PlaceableTileEntity;
import net.minecraft.level.Level;
import net.minecraft.level.TileView;
import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.maths.MathHelper;
import net.modificationstation.stationloader.api.common.block.BlockHardnessPerMeta;
import net.modificationstation.stationloader.api.common.block.BlockItemProvider;
import net.modificationstation.stationloader.api.common.block.BlockStrengthPerMeta;
import net.modificationstation.stationloader.api.common.preset.block.HasPlaceableTileEntityWithMetaAndName;

import java.util.Random;

public class BlockMaterialChest extends BlockWithEntity implements HasPlaceableTileEntityWithMetaAndName, BlockHardnessPerMeta, BlockItemProvider {

    private final Random random = new Random();

    public BlockMaterialChest(int i) {

        super(i, Material.METAL);
    }

    @Override
    protected TileEntityBase createTileEntity() {
        return null;
    }

    public TileEntityBase getBlockEntity(int i) {
        if(i == 0)
            return new TileEntityIronChest();
        if(i == 1)
            return new TileEntityGoldChest();
        return new TileEntityDiamondChest();
    }

    @Override
    public void onBlockPlaced(Level level, int x, int y, int z) {
        TileEntityBase tileEntity = getBlockEntity(level.getTileMeta(x, y, z));
        //System.out.println("meta:" + level.getTileMeta(x, y, z));
        level.setTileEntity(x, y, z, tileEntity);
    }

    @Override
    public int getTextureForSide(int side, int data) {
        if (data == 0) {
            if (side == 1)
                return TextureListener.ironChest[2];
            if (side == 0)
                return TextureListener.ironChest[2];
            if (side == 3)
                return TextureListener.ironChest[0];
            return TextureListener.ironChest[1];
        }
        if (data == 1) {
            if (side == 1)
                return TextureListener.goldChest[2];
            if (side == 0)
                return TextureListener.goldChest[2];
            if (side == 3)
                return TextureListener.goldChest[0];
            return TextureListener.goldChest[1];
        }
        if (data == 2) {
            if (side == 1)
                return TextureListener.diamondChest[2];
            if (side == 0)
                return TextureListener.diamondChest[2];
            if (side == 3)
                return TextureListener.diamondChest[0];
            return TextureListener.diamondChest[1];
        }
        if (data == 3) {
            if (side == 1)
                return TextureListener.obsidianChest[2];
            if (side == 0)
                return TextureListener.obsidianChest[2];
            if (side == 3)
                return TextureListener.obsidianChest[0];
            return TextureListener.obsidianChest[1];
        }

        return 0;// super.getTextureForSide(side, data);
    }

    @Override
    public void afterPlaced(Level arg, int i, int j, int k, Living arg1) {
        TileEntityBase tileEntity = arg.getTileEntity(i, j, k);
        if (arg1 == null)
            return;
        int var6 = MathHelper.floor((double) (arg1.yaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (var6 == 0) {
            ((TileEntityBlock) tileEntity).setFacing((short) 2);
        }

        if (var6 == 1) {
            ((TileEntityBlock) tileEntity).setFacing((short) 5);
        }

        if (var6 == 2) {
            ((TileEntityBlock) tileEntity).setFacing((short) 3);
        }

        if (var6 == 3) {
            ((TileEntityBlock) tileEntity).setFacing((short) 4);
        }
        super.afterPlaced(arg, i, j, k, arg1);
    }

    @Override
    public void onBlockRemoved(Level level, int x, int y, int z) {
        InventoryBase tileEntity = (InventoryBase) level.getTileEntity(x, y, z);

        for (int var6 = 0; var6 < tileEntity.getInventorySize(); ++var6) {
            ItemInstance var7 = tileEntity.getInventoryItem(var6);
            if (var7 != null) {
                float var8 = this.random.nextFloat() * 0.8F + 0.1F;
                float var9 = this.random.nextFloat() * 0.8F + 0.1F;
                float var10 = this.random.nextFloat() * 0.8F + 0.1F;

                while (var7.count > 0) {
                    int var11 = this.random.nextInt(21) + 10;
                    if (var11 > var7.count) {
                        var11 = var7.count;
                    }

                    var7.count -= var11;
                    Item var12 = new Item(level, (float) x + var8, (float) y + var9,
                            (float) z + var10, new ItemInstance(var7.itemId, var11, var7.getDamage()));
                    float var13 = 0.05F;
                    var12.velocityX = (float) this.random.nextGaussian() * var13;
                    var12.velocityY = (float) this.random.nextGaussian() * var13 + 0.2F;
                    var12.velocityZ = (float) this.random.nextGaussian() * var13;
                    level.spawnEntity(var12);
                }

                tileEntity.setInventoryItem(var6, null);
            }
        }

        super.onBlockRemoved(level, x, y, z);
    }

    @Override
    public int method_1626(TileView arg, int x, int y, int z, int side) {
        TileEntityBase tileEntity = arg.getTileEntity(x, y, z);
        short word0 = (tileEntity instanceof TileEntityBlock) ? ((TileEntityBlock) tileEntity).getFacing() : 2;
        int data = arg.getTileMeta(x, y, z);
        if (data == 0) {
            if (side == 1)
                return TextureListener.ironChest[2];
            if (side == 0)
                return TextureListener.ironChest[2];
            if (side == word0)
                return TextureListener.ironChest[0];
            return TextureListener.ironChest[1];
        }
        if (data == 1) {
            if (side == 1)
                return TextureListener.goldChest[2];
            if (side == 0)
                return TextureListener.goldChest[2];
            if (side == word0)
                return TextureListener.goldChest[0];
            return TextureListener.goldChest[1];
        }
        if (data == 2) {
            if (side == 1)
                return TextureListener.diamondChest[2];
            if (side == 0)
                return TextureListener.diamondChest[2];
            if (side == word0)
                return TextureListener.diamondChest[0];
            return TextureListener.diamondChest[1];
        }
        if (data == 3) {
            if (side == 1)
                return TextureListener.obsidianChest[2];
            if (side == 0)
                return TextureListener.obsidianChest[2];
            if (side == word0)
                return TextureListener.obsidianChest[0];
            return TextureListener.obsidianChest[1];
        }
        return 0;
    }

    @Override
    protected int droppedMeta(int i) {
        return i;
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return id;
    }

/*    @Override
    public PlaceableTileEntity getBlockItem(int i) {
        return new ItemBlockMaterialChest(i);
    }*/

    @SuppressWarnings("static-access")
    @Override
    public boolean canUse(Level level, int x, int y, int z, PlayerBase player) {
        int data = level.getTileMeta(x, y, z);
        if (data == 0) {
            TileEntityIronChest var6 = (TileEntityIronChest) level.getTileEntity(x, y, z);
            GuiIronChest guiironchest = new GuiIronChest(player.inventory,
                    (TileEntityIronChest) level.getTileEntity(x, y, z));
            var6.setTmpName("Iron Chest");
            if (level.getTileId(x, y + 1, z) > 0)
                return true;
            if (level.isClient)
                return true;
            var6.player = player;
            IronChestMod.openGui(guiironchest);
            // IronChestMod.openGui(player, 1, (InventoryBase) var6, new
            // ContainerIronChest(player.inventory, var6));
            return true;
        }
        if (data == 1) {
            TileEntityGoldChest var6 = (TileEntityGoldChest) level.getTileEntity(x, y, z);
            GuiGoldChest guigoldchest = new GuiGoldChest(player.inventory,
                    (TileEntityGoldChest) level.getTileEntity(x, y, z));
            var6.setTmpName("Gold Chest");
            if (level.getTileId(x, y + 1, z) > 0)
                return true;
            if (level.isClient)
                return true;
            var6.player = player;
            IronChestMod.openGui(guigoldchest);
            // IronChestMod.openGui(player, 2, (InventoryBase) var6, new
            // ContainerGoldChest(player.inventory, var6));
            return true;
        }
        if (data == 2) {
            TileEntityDiamondChest var6 = (TileEntityDiamondChest) level.getTileEntity(x, y, z);
            GuiDiamondChest guidiamondchest = new GuiDiamondChest(player.inventory,
                    (TileEntityDiamondChest) level.getTileEntity(x, y, z));
            var6.setTmpName("Diamond Chest");
            if (level.getTileId(x, y + 1, z) > 0)
                return true;
            if (level.isClient)
                return true;
            IronChestMod.openGui(guidiamondchest);
            // IronChestMod.openGui(player, 3, (InventoryBase) var6, new
            // ContainerDiamondChest(player.inventory, var6));
            return true;
        }
        if (data == 3) {
            TileEntityDiamondChest var6 = (TileEntityDiamondChest) level.getTileEntity(x, y, z);
            GuiDiamondChest guidiamondchest = new GuiDiamondChest(player.inventory,
                    (TileEntityDiamondChest) level.getTileEntity(x, y, z));
            var6.setTmpName("Obsidian Chest");
            if (level.getTileId(x, y + 1, z) > 0)
                return true;
            if (level.isClient)
                return true;
            IronChestMod.openGui(guidiamondchest);
            // IronChestMod.openGui(player, 3, (InventoryBase) var6, new
            // ContainerDiamondChest(player.inventory, var6));
            return true;
        }
        return true;
    }

    @Override
    public float getHardness(int i) {
        if(i == 3)
            return 2.0F;
        return 1.0F;
    }

    /*@Override
    public float getBlockStrength(PlayerBase player, int i) {
        return 10.0f;
    }*/

    @Override
    public float getBlastResistance(EntityBase arg) {
        return BlockBase.OBSIDIAN.getBlastResistance(arg);
    }
}
