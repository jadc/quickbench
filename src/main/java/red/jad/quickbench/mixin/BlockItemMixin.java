package red.jad.quickbench.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import red.jad.quickbench.Quickbench;

@Mixin(BlockItem.class)
public class BlockItemMixin {
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if(!world.isClient()){
            if(player.getStackInHand(hand).getItem().equals(Blocks.CRAFTING_TABLE.asItem())){
                Quickbench.openCraftingInterface(player);
            }
        }
        return TypedActionResult.pass(player.getStackInHand(hand));
    }
}