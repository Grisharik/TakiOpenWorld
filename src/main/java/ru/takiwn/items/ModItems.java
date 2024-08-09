package ru.takiwn.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import ru.takiwn.TakiOpenWorld;
import ru.takiwn.materials.KritanaMaterial;
import ru.takiwn.materials.Kritana;
import ru.takiwn.materials.Ranmer;
import ru.takiwn.materials.RanmerMaterial;

import static net.minecraft.item.SwordItem.createAttributeModifiers;

public class ModItems {

    public static final Item WARDEN_HEART = register(
            new Item(new Item.Settings()), "warden_heart"
    );

    public static final Item DICE_D6 = register(new Item(new Item.Settings().maxCount(8).fireproof()), "dice_d6");

    public static final Item KRITANA = register(new Kritana(KritanaMaterial.INSTANCE,
            new Item.Settings().attributeModifiers(createAttributeModifiers(KritanaMaterial.INSTANCE, 7, -2.4F))
                    .rarity(Rarity.RARE).fireproof()), "kritana");

    public static final Item RANMER = register(new Ranmer(RanmerMaterial.INSTANCE,
            new Item.Settings().attributeModifiers(
                    createAttributeModifiers(RanmerMaterial.INSTANCE, 0, -2.0F)).rarity(Rarity.EPIC)), "ranmer");

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(TakiOpenWorld.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
    }
}
