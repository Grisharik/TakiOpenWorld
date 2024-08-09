package ru.takiwn;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.takiwn.items.ModItems;
import ru.takiwn.materials.HammerTier;
import ru.takiwn.materials.Ranmer;

public class TakiOpenWorld implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("takiopenworld");
	public static final String MOD_ID = "takiopenworld";

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from takiwn!");
		ModItems.initialize();
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			ItemStack stack = player.getStackInHand(hand);
				HammerTier randomTier = HammerTier.getRandomTier();
				Ranmer.setHammerTier(stack, randomTier);
			return ActionResult.PASS;
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
				.register((itemGroup) -> itemGroup.add(ModItems.DICE_D6));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
				.register((itemGroup) -> itemGroup.add(ModItems.RANMER));
	}
}