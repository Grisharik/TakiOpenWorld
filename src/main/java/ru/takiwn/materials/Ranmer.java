package ru.takiwn.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Random;

public class Ranmer extends Item {

    public Ranmer() {
        super(new FabricItemSettings().maxCount(1));
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);

        if (!world.isClient()) {
            Random random = new Random();
            int tier = random.nextInt(5) + 1;  // Тир от 1 до 5

            // Сохранение тира в NBT
            NbtCompound nbt = stack.getOrCreateNbt();
            nbt.putInt("RunMirrorTier", tier);
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int tier = getTier(stack);
        int damage = calculateDamage(tier);

        target.damage(DamageSource.GENERIC, damage);
        return super.postHit(stack, target, attacker);
    }

    private int getTier(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        return nbt != null && nbt.contains("RunMirrorTier") ? nbt.getInt("RunMirrorTier") : 1;
    }

    private int calculateDamage(int tier) {
        Random random = new Random();
        switch (tier) {
            case 1: return random.nextInt(8) + 1;
            case 2: return random.nextInt(5) + 4;
            case 3: return random.nextInt(6) + 5;
            case 4: return random.nextInt(5) + 6;
            case 5: return random.nextInt(7) + 6;
            default: return 1;
        }
    }
}