package lilylicious.thaumicequivalence.emc;

import lilylicious.thaumicequivalence.config.TEConfig;
import lilylicious.thaumicequivalence.utils.TELogger;
import moze_intel.projecte.api.ProjectEAPI;
import net.minecraft.item.ItemStack;
import org.lwjgl.util.glu.Project;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.common.lib.crafting.InfusionRunicAugmentRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ThaumicMapper
{


	public static void addConversions()
	{

		if (TEConfig.aspectEMC)
		{
			AspectMapper.mapAspects();
		}
		
		ManualEMC.addEMC();

		for (Object recipe : ThaumcraftApi.getCraftingRecipes())
		{
			if (recipe instanceof InfusionRunicAugmentRecipe) continue;

			if (recipe instanceof ShapedArcaneRecipe && TEConfig.shapedArcaneEMC)
			{
				ProjectEAPI.getRecipeProxy().addRecipe(((ShapedArcaneRecipe) recipe).getRecipeOutput().stackSize, ((ShapedArcaneRecipe) recipe).getRecipeOutput(), getIngredients((ShapedArcaneRecipe) recipe));
			} else if (recipe instanceof ShapelessArcaneRecipe && TEConfig.shapelessArcaneEMC)
			{
				ProjectEAPI.getRecipeProxy().addRecipe(((ShapelessArcaneRecipe) recipe).getRecipeOutput().stackSize, ((ShapelessArcaneRecipe) recipe).getRecipeOutput(), getIngredients((ShapelessArcaneRecipe) recipe));
			} else if (recipe instanceof InfusionRecipe && TEConfig.infusionEMC)
			{
				if (!(((InfusionRecipe) recipe).getRecipeOutput() instanceof Object[]))
					ProjectEAPI.getRecipeProxy().addRecipe(1, ((InfusionRecipe) recipe).getRecipeOutput(), getIngredients((InfusionRecipe) recipe));
			} else if (recipe instanceof CrucibleRecipe && TEConfig.crucibleEMC)
			{
				ProjectEAPI.getRecipeProxy().addRecipe(((CrucibleRecipe) recipe).getRecipeOutput().stackSize, ((CrucibleRecipe) recipe).getRecipeOutput(), getIngredients((CrucibleRecipe) recipe));
			}

			
		}


	}

	private static Map<Object, Integer> getIngredients(ShapedArcaneRecipe recipe)
	{
		Map<Object, Integer> ingredients = new HashMap<Object, Integer>();

		for (Aspect aspect : recipe.getAspects().getAspects())
		{
			ingredients.put(AspectMapper.map.get(aspect.getTag()), recipe.getAspects().getAmount(aspect));
		}

		for (Object o : recipe.getInput())
		{
			int prevValue = 0;

			if (ingredients.get(o) != null)
			{
				prevValue = ingredients.get(o);
			}

			if (o instanceof ItemStack)
			{
				ingredients.put(o, prevValue + ((ItemStack) o).stackSize);
			} else if (o instanceof ArrayList && ((ArrayList) o).size() > 0)
			{
				ingredients.put(getObjectFromList((ArrayList) o), prevValue + 1);
			}
		}


		return ingredients;
	}

	private static Map<Object, Integer> getIngredients(ShapelessArcaneRecipe recipe)
	{
		Map<Object, Integer> ingredients = new HashMap<Object, Integer>();

		for (Aspect aspect : recipe.getAspects().getAspects())
		{
			ingredients.put(AspectMapper.map.get(aspect.getTag()), recipe.getAspects().getAmount(aspect));
		}

		for (Object o : recipe.getInput())
		{
			int prevValue = 0;

			if (ingredients.get(o) != null)
			{
				prevValue = ingredients.get(o);
			}

			if (o instanceof ItemStack)
			{
				ingredients.put(o, prevValue + ((ItemStack) o).stackSize);
			} else if (o instanceof ArrayList && ((ArrayList) o).size() > 0)
			{
				ingredients.put(getObjectFromList((ArrayList) o), prevValue + 1);
			}
		}

		return ingredients;
	}

	private static Map<Object, Integer> getIngredients(InfusionRecipe recipe)
	{
		Map<Object, Integer> ingredients = new HashMap<Object, Integer>();

		for (Aspect aspect : recipe.getAspects().getAspects())
		{
			ingredients.put(AspectMapper.map.get(aspect.getTag()), recipe.getAspects().getAmount(aspect));
		}

		for (ItemStack o : recipe.getComponents())
		{
			int prevValue = 0;

			if (ingredients.get(o) != null)
			{
				prevValue = ingredients.get(o);
			}

			ingredients.put(o, prevValue + o.stackSize);
		}


		int prevValue = 0;

		if (ingredients.get(recipe.getRecipeInput()) != null)
		{
			prevValue = ingredients.get(recipe.getRecipeInput());
		}

		ingredients.put(recipe.getRecipeInput(), prevValue + recipe.getRecipeInput().stackSize);

		return ingredients;
	}

	private static Map<Object, Integer> getIngredients(CrucibleRecipe recipe)
	{
		Map<Object, Integer> ingredients = new HashMap<Object, Integer>();

		for (Aspect aspect : recipe.aspects.getAspects())
		{
			ingredients.put(AspectMapper.map.get(aspect.getTag()), recipe.aspects.getAmount(aspect));
		}

		if (recipe.catalyst instanceof ArrayList && ((ArrayList) recipe.catalyst).size() > 0)
		{
			ingredients.put(getObjectFromList((ArrayList) recipe.catalyst), 1);
		} else if (recipe.catalyst instanceof ItemStack)
		{
			ingredients.put(recipe.catalyst, 1);
		} else TELogger.logFatal("Catalyst is wrong type!", recipe.catalyst);
		return ingredients;
	}

	private static Object getObjectFromList(ArrayList list)
	{

		Object fakeItem = new Object();
		Map<Object, Integer> map = new HashMap();

		for (Object o : list)
		{
			map.put(o, 1);
			ProjectEAPI.getRecipeProxy().addRecipe(1, fakeItem, map);
			map.clear();
		}

		return fakeItem;
	}

}