package com.daniel.iterr.init;

import com.daniel.iterr.Iterr;
import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Iterr.MOD_ID);
	
	public static final RegistryObject<Item> DRAGON_STEAK = register("dragon_steak", () -> new Item(new Item.Properties()
			.tab(Iterr.ITERR_TAB).food(new FoodProperties.Builder().alwaysEat().nutrition(20).saturationMod(3.0f)
			.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 20000, 3), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 40, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 3), 1.0f).build())));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}
