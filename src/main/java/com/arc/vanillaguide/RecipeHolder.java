package com.arc.vanillaguide;

import amerifrance.guideapi.pages.PageFurnaceRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public class RecipeHolder
{
    private static List recipeList;

    //Crafting Recipes
    public static IRecipe woodenPlanks;
    public static IRecipe craftingTable;
    public static IRecipe woodenPickaxe;
    public static IRecipe torch;
    public static IRecipe chest;
    public static IRecipe furnace;
    public static IRecipe stonePickaxe;
    public static IRecipe stoneSword;
    public static IRecipe hoe;
    public static IRecipe bread;
    public static IRecipe woodenDoor;
    public static IRecipe bed;
    public static IRecipe ironPickaxe;
    public static IRecipe ironChestplate;
    public static IRecipe compass;
    public static IRecipe clock;

    public static IRecipe bucket;
    public static IRecipe boat;
    public static IRecipe tnt;
    public static IRecipe tntMinecart;
    public static IRecipe diamondPickaxe;
    public static IRecipe book;
    public static IRecipe bookshelf;
    public static IRecipe enchantingTable;
    public static IRecipe anvil;
    public static IRecipe brewingStand;
    public static IRecipe emptyBottle;
    public static IRecipe rails;
    public static IRecipe minecart;
    public static IRecipe poweredRails;
    public static IRecipe chestMinecart;
    public static IRecipe furnaceMinecart;
    public static IRecipe activatorRail;
    public static IRecipe detectorRail;
    public static IRecipe fireworkStar;
    public static IRecipe firework;
    public static IRecipe stairs;
    public static IRecipe slabs;
    public static IRecipe fence;
    public static IRecipe fenceGate;
    public static IRecipe ladder;
    public static IRecipe carpet;
    public static IRecipe snow;
    public static IRecipe eyeOfEnder;
    public static IRecipe enderChest;
    public static IRecipe beacon;

    public static IRecipe diamondAxe;
    public static IRecipe diamondShovel;
    public static IRecipe diamondHoe;
    public static IRecipe diamondSword;
    public static IRecipe flintAndSteel;
    public static IRecipe fishingRod;
    public static IRecipe bow;
    public static IRecipe arrow;
    public static IRecipe shears;
    public static IRecipe diamondHelmet;
    public static IRecipe diamondChestplate;
    public static IRecipe diamondLeggings;
    public static IRecipe diamondBoots;
    public static IRecipe carrotOnStick;

    public static IRecipe trapdoor;
    public static IRecipe sign;
    public static IRecipe melonSeeds;
    public static IRecipe pumpkinSeeds;
    public static IRecipe jackOLantern;
    public static IRecipe boneMeal;
    public static IRecipe mushroomSoup;
    public static IRecipe cookies;
    public static IRecipe pumpkinPie;
    public static IRecipe cake;
    public static IRecipe goldenApple;
    public static IRecipe enchantedApple;

    public static IRecipe lever;
    public static IRecipe button;
    public static IRecipe redstoneTorch;
    public static IRecipe daylightSensor;
    public static IRecipe pressurePlate;
    public static IRecipe heavyPressurePlate;
    public static IRecipe redstoneBlock;
    public static IRecipe redstoneRepeater;
    public static IRecipe redstoneComparator;
    public static IRecipe hopper;
    public static IRecipe piston;
    public static IRecipe redstoneLamp;
    public static IRecipe tripwireHook;
    public static IRecipe trappedChest;

    //Furnace Recipes
    public static PageFurnaceRecipe glass;
    public static PageFurnaceRecipe ironIngot;
    public static PageFurnaceRecipe cookedChicken;
    public static PageFurnaceRecipe cookedBeef;

    public static void init()
    {
        recipeList = CraftingManager.getInstance().getRecipeList();

        woodenPlanks = getRecipeForItemStack(new ItemStack(Blocks.planks));
        craftingTable = getRecipeForItemStack(new ItemStack(Blocks.crafting_table));
        woodenPickaxe = getRecipeForItemStack(new ItemStack(Items.wooden_pickaxe));
        torch = getRecipeForItemStack(new ItemStack(Blocks.torch));
        chest = getRecipeForItemStack(new ItemStack(Blocks.chest));
        furnace = getRecipeForItemStack(new ItemStack(Blocks.furnace));
        stonePickaxe = getRecipeForItemStack(new ItemStack(Items.stone_pickaxe));
        stoneSword = getRecipeForItemStack(new ItemStack(Items.stone_sword));
        hoe = getRecipeForItemStack(new ItemStack(Items.wooden_hoe));
        bread = getRecipeForItemStack(new ItemStack(Items.bread));
        woodenDoor = getRecipeForItemStack(new ItemStack(Items.wooden_door));
        bed = getRecipeForItemStack(new ItemStack(Items.bed));
        ironPickaxe = getRecipeForItemStack(new ItemStack(Items.iron_pickaxe));
        ironChestplate = getRecipeForItemStack(new ItemStack(Items.iron_chestplate));
        compass = getRecipeForItemStack(new ItemStack(Items.compass));
        clock = getRecipeForItemStack(new ItemStack(Items.clock));

        bucket = getRecipeForItemStack(new ItemStack(Items.bucket));
        boat = getRecipeForItemStack(new ItemStack(Items.boat));
        tnt = getRecipeForItemStack(new ItemStack(Blocks.tnt));
        tntMinecart = getRecipeForItemStack(new ItemStack(Items.tnt_minecart));
        diamondPickaxe = getRecipeForItemStack(new ItemStack(Items.diamond_pickaxe));
        book = getRecipeForItemStack(new ItemStack(Items.book));
        bookshelf = getRecipeForItemStack(new ItemStack(Blocks.bookshelf));
        enchantingTable = getRecipeForItemStack(new ItemStack(Blocks.enchanting_table));
        anvil = getRecipeForItemStack(new ItemStack(Blocks.anvil));
        brewingStand = getRecipeForItemStack(new ItemStack(Items.brewing_stand));
        emptyBottle = getRecipeForItemStack(new ItemStack(Items.glass_bottle));
        rails = getRecipeForItemStack(new ItemStack(Blocks.rail));
        minecart = getRecipeForItemStack(new ItemStack(Items.minecart));
        poweredRails = getRecipeForItemStack(new ItemStack(Blocks.golden_rail));
        chestMinecart = getRecipeForItemStack(new ItemStack(Items.chest_minecart));
        furnaceMinecart = getRecipeForItemStack(new ItemStack(Items.furnace_minecart));
        activatorRail = getRecipeForItemStack(new ItemStack(Blocks.activator_rail));
        detectorRail = getRecipeForItemStack(new ItemStack(Blocks.detector_rail));
        fireworkStar = getRecipeForItemStack(new ItemStack(Items.firework_charge));
        firework = getRecipeForItemStack(new ItemStack(Items.fireworks));
        stairs = getRecipeForItemStack(new ItemStack(Blocks.stone_stairs));
        slabs = getRecipeForItemStack(new ItemStack(Blocks.stone_slab));
        fence = getRecipeForItemStack(new ItemStack(Blocks.fence));
        fenceGate = getRecipeForItemStack(new ItemStack(Blocks.fence_gate));
        ladder = getRecipeForItemStack(new ItemStack(Blocks.ladder));
        carpet = getRecipeForItemStack(new ItemStack(Blocks.carpet));
        snow = getRecipeForItemStack(new ItemStack(Blocks.snow));
        eyeOfEnder = getRecipeForItemStack(new ItemStack(Items.ender_eye));
        enderChest = getRecipeForItemStack(new ItemStack(Blocks.ender_chest));
        beacon = getRecipeForItemStack(new ItemStack(Blocks.beacon));

        diamondAxe = getRecipeForItemStack(new ItemStack(Items.diamond_axe));
        diamondShovel = getRecipeForItemStack(new ItemStack(Items.diamond_shovel));
        diamondHoe = getRecipeForItemStack(new ItemStack(Items.diamond_hoe));
        diamondSword = getRecipeForItemStack(new ItemStack(Items.diamond_sword));
        flintAndSteel = getRecipeForItemStack(new ItemStack(Items.flint_and_steel));
        fishingRod = getRecipeForItemStack(new ItemStack(Items.fishing_rod));
        bow = getRecipeForItemStack(new ItemStack(Items.bow));
        arrow = getRecipeForItemStack(new ItemStack(Items.arrow, 4));
        shears = getRecipeForItemStack(new ItemStack(Items.shears));
        diamondHelmet = getRecipeForItemStack(new ItemStack(Items.diamond_helmet));
        diamondChestplate = getRecipeForItemStack(new ItemStack(Items.diamond_chestplate));
        diamondLeggings = getRecipeForItemStack(new ItemStack(Items.diamond_leggings));
        diamondBoots = getRecipeForItemStack(new ItemStack(Items.diamond_boots));
        carrotOnStick = getRecipeForItemStack(new ItemStack(Items.carrot_on_a_stick));

        trapdoor = getRecipeForItemStack(new ItemStack(Blocks.trapdoor));
        sign = getRecipeForItemStack(new ItemStack(Items.sign));
        melonSeeds = getRecipeForItemStack(new ItemStack(Items.melon_seeds));
        pumpkinSeeds = getRecipeForItemStack(new ItemStack(Items.pumpkin_seeds, 4));
        jackOLantern = getRecipeForItemStack(new ItemStack(Blocks.lit_pumpkin));
        boneMeal = getRecipeForItemStack(new ItemStack(Items.dye, 3, 15));
        mushroomSoup = getRecipeForItemStack(new ItemStack(Items.mushroom_stew));
        cookies = getRecipeForItemStack(new ItemStack(Items.cookie));
        pumpkinPie = getRecipeForItemStack(new ItemStack(Items.pumpkin_pie));
        cake = getRecipeForItemStack(new ItemStack(Items.cake));
        goldenApple = getRecipeForItemStack(new ItemStack(Items.golden_apple));
        enchantedApple = getRecipeForItemStack(new ItemStack(Items.golden_apple, 1, 1));

        lever = getRecipeForItemStack(new ItemStack(Blocks.lever));
        button = getRecipeForItemStack(new ItemStack(Blocks.stone_button));
        redstoneTorch = getRecipeForItemStack(new ItemStack(Blocks.redstone_torch));
        daylightSensor = getRecipeForItemStack(new ItemStack(Blocks.daylight_detector));
        pressurePlate = getRecipeForItemStack(new ItemStack(Blocks.stone_pressure_plate));
        heavyPressurePlate = getRecipeForItemStack(new ItemStack(Blocks.heavy_weighted_pressure_plate));
        redstoneBlock = getRecipeForItemStack(new ItemStack(Blocks.redstone_block));
        redstoneRepeater = getRecipeForItemStack(new ItemStack(Items.repeater));
        redstoneComparator = getRecipeForItemStack(new ItemStack(Items.comparator));
        hopper = getRecipeForItemStack(new ItemStack(Blocks.hopper));
        piston = getRecipeForItemStack(new ItemStack(Blocks.piston));
        redstoneLamp = getRecipeForItemStack(new ItemStack(Blocks.redstone_lamp));
        tripwireHook = getRecipeForItemStack(new ItemStack(Blocks.tripwire_hook));
        trappedChest = getRecipeForItemStack(new ItemStack(Blocks.trapped_chest));

        glass = new PageFurnaceRecipe(new ItemStack(Blocks.sand));
        ironIngot = new PageFurnaceRecipe(new ItemStack(Blocks.iron_ore));
        cookedChicken = new PageFurnaceRecipe(new ItemStack(Items.chicken));
        cookedBeef = new PageFurnaceRecipe(new ItemStack(Items.beef));
    }

    private static IRecipe getRecipeForItemStack(ItemStack stack)
    {
        for (Object obj : recipeList)
        {
            IRecipe recipe = (IRecipe) obj;
            if (recipe.getRecipeOutput() != null && stack.isItemEqual(recipe.getRecipeOutput()))
            {
                return recipe;
            }
        }

        return null;
    }
}
