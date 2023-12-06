package me.codecraft.darkendepths.item.custom;

import me.codecraft.darkendepths.inventory.ShadowStoneInventory;
import me.codecraft.darkendepths.mixinInterface.IPlayerInventroyMixin;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class ShadowStoneItem extends Item {

    public ShadowStoneItem(Settings settings) {
        super(settings);
    }
    public static GenericContainerScreenHandler createGeneric9x4(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X4, syncId, playerInventory, inventory, 4);
    }


    MutableText Text1 = Text.translatable("screen.darkendepths.shadowstone_inventory");

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(!world.isClient&&user instanceof ServerPlayerEntity){
            ShadowStoneInventory shadowStoneInventory;
            shadowStoneInventory = ((IPlayerInventroyMixin)user).getShadowStoneInventory();
            user.sendMessage(Text.literal("Supp mate"));
            NamedScreenHandlerFactory screenHandlerFactory = new SimpleNamedScreenHandlerFactory((syncId, playerInventory, playerEntity) -> createGeneric9x4(syncId,playerInventory,shadowStoneInventory),Text1);
            // Send a packet to the client to open the GUI
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) user;
            serverPlayerEntity.openHandledScreen(screenHandlerFactory);

        }

        return super.use(world, user, hand);
    }



}
