package com.daniel.iterr.event.loot;

import java.util.List;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class SteakFromDragonAdditionModiffier extends LootModifier{
	private final Item addition;
	
	protected SteakFromDragonAdditionModiffier(LootItemCondition[] conditionsIn, Item addition) {
		super(conditionsIn);
		this.addition = addition;
	}

	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		generatedLoot.add(new ItemStack(addition, 1));
		return generatedLoot;
		
	}

	public static class Serializer extends GlobalLootModifierSerializer<SteakFromDragonAdditionModiffier>{

		@Override
		public SteakFromDragonAdditionModiffier read(ResourceLocation location, JsonObject object,
				LootItemCondition[] ailootcondition) {
			Item addition = ForgeRegistries.ITEMS.getValue(
					new ResourceLocation(GsonHelper.getAsString(object, "addition")));
			return new SteakFromDragonAdditionModiffier(ailootcondition, addition);
		}

		@Override
		public JsonObject write(SteakFromDragonAdditionModiffier instance) {
			JsonObject json = makeConditions(instance.conditions);
			json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
			return json;
		}
		
	}
}
