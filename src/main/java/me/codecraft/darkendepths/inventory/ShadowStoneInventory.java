package me.codecraft.darkendepths.inventory;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class ShadowStoneInventory extends SimpleInventory {
    public ShadowStoneInventory() {
        super(36);
    }

    @Override
    public void readNbtList(NbtList nbtList) {
        int i;
        for (i = 0; i < this.size(); ++i) {
            this.setStack(i, ItemStack.EMPTY);
        }
        for (i = 0; i < nbtList.size(); ++i) {
            NbtCompound nbtCompound = nbtList.getCompound(i);
            int j = nbtCompound.getByte("Slot") & 0xFF;
            if (j < 0 || j >= this.size()) continue;
            this.setStack(j, ItemStack.fromNbt(nbtCompound));
        }
    }

    @Override
    public NbtList toNbtList() {
        NbtList nbtList = new NbtList();
        for (int i = 0; i < this.size(); ++i) {
            ItemStack itemStack = this.getStack(i);
            if (itemStack.isEmpty()) continue;
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putByte("Slot", (byte)i);
            itemStack.writeNbt(nbtCompound);
            nbtList.add(nbtCompound);
        }
        return nbtList;
    }
}
