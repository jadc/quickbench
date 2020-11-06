package red.jad.quickbench;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.TranslatableText;

public class Quickbench {
	public static void openCraftingInterface(PlayerEntity player){
		player.openHandledScreen(
				new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity)
						-> { 	return new MobileCraftingScreenHandler(i, playerInventory,
						ScreenHandlerContext.create(player.getEntityWorld(), null)); },
						new TranslatableText("container.crafting"))
		);
		player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
	}

	public static class MobileCraftingScreenHandler extends CraftingScreenHandler {
		public MobileCraftingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
			super(syncId, playerInventory, context);
		}

		@Override
		public boolean canUse(PlayerEntity player) {
			return true;
		}
	}
}


