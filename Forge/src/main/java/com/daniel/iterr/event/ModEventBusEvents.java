package com.daniel.iterr.event;

import org.checkerframework.checker.nullness.qual.NonNull;

import com.daniel.iterr.Iterr;
import com.daniel.iterr.event.loot.SteakFromDragonAdditionModiffier;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Iterr.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
	
	@SubscribeEvent
	public static void registerModiffierSerializer(final RegistryEvent.@NonNull Register<GlobalLootModifierSerializer<?>> event) {
		
		event.getRegistry().registerAll(
				new SteakFromDragonAdditionModiffier.Serializer().setRegistryName
				(new ResourceLocation(Iterr.MOD_ID, "steak_from_dragon"))
		);
	}
}
