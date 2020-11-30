package net.glasslauncher.ironchest;

import net.minecraft.tileentity.TileEntityBase;
import net.minecraft.util.io.CompoundTag;

public class TileEntityBlock extends TileEntityBase {
	private short facing = 2;
	private boolean created;

	public void setFacing(short word0) {
		this.facing = word0;
	}

	public short getFacing() {
		return this.facing;
	}

	@Override
	public void writeIdentifyingData(CompoundTag tag) {
		tag.put("facing", facing);
		super.writeIdentifyingData(tag);
	}

	@Override
	public void readIdentifyingData(CompoundTag tag) {
		this.facing = tag.getShort("facing");
		super.readIdentifyingData(tag);
	}
}
