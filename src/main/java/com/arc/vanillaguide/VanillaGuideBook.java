package com.arc.vanillaguide;

import amerifrance.guideapi.api.GuideRegistry;
import amerifrance.guideapi.api.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.abstraction.EntryAbstract;
import amerifrance.guideapi.api.abstraction.IPage;
import amerifrance.guideapi.api.base.Book;
import amerifrance.guideapi.api.util.BookBuilder;
import amerifrance.guideapi.api.util.PageHelper;
import amerifrance.guideapi.categories.CategoryItemStack;
import amerifrance.guideapi.entries.EntryUniText;
import amerifrance.guideapi.pages.PageIRecipe;
import amerifrance.guideapi.pages.PageUnlocImage;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VanillaGuideBook
{
    public static Book vanillaGuide;
    public static List<CategoryAbstract> categories = new ArrayList();
    private final static String R_LOC = "VanillaGuide:images/";

    public static void registerBook()
    {
        registerStartingEntries();
        registerdoingEverythingEntries();
        registerToolsEntries();
        registerBotanistEntries();
        registerRedstoneEntries();
        registerEntitiesEntries();
        registerWorldEntries();
        registerStatsEntries();

        BookBuilder bookBuilder = new BookBuilder();
        bookBuilder.setCategories(categories).setUnlocBookTitle("guide.vanilla.book.title").setUnlocWelcomeMessage("guide.vanilla.book.welcomeMessage").setUnlocDisplayName("guide.vanilla.book.displayName").setBookColor(new Color(66, 255, 144)).setAuthor("guide.vanilla.book.author");
        vanillaGuide = bookBuilder.build();
        GuideRegistry.registerBook(vanillaGuide);
    }

    private static void registerStartingEntries()
    {
        List<EntryAbstract> startingEntries = new ArrayList<EntryAbstract>();

        //Intro
        ArrayList<IPage> introPages = new ArrayList<IPage>();
        makePage(startingEntries, introPages, "intro");

        //Getting Started
        ArrayList<IPage> gettingStartedPages = new ArrayList<IPage>();
        makePage(startingEntries, gettingStartedPages, "gettingStarted", r(RecipeHolder.woodenPlanks, RecipeHolder.craftingTable), s("gettingStarted2"), r(RecipeHolder.woodenPickaxe, RecipeHolder.furnace, RecipeHolder.torch, RecipeHolder.chest));

        //The Stone Age
        ArrayList<IPage> stoneAge = new ArrayList<IPage>();
        makePage(startingEntries, stoneAge, "stoneAge", r(RecipeHolder.stonePickaxe, RecipeHolder.stoneSword));

        //I'm Getting Hungry
        ArrayList<IPage> gettingHungry = new ArrayList<IPage>();
        makePage(startingEntries, gettingHungry, "gettingHungry", RecipeHolder.cookedChicken, s("gettingHungry2"), r(RecipeHolder.hoe, RecipeHolder.bread));

        //Let's Build A House
        ArrayList<IPage> buildAHouse = new ArrayList<IPage>();
        makePage(startingEntries, buildAHouse, "buildAHouse", r(RecipeHolder.woodenDoor), s("buildAHouse2"), RecipeHolder.glass, s("buildAHouse3"), r(RecipeHolder.bed));

        //The Iron Age
        ArrayList<IPage> ironAge = new ArrayList<IPage>();
        makePage(startingEntries, ironAge, "ironAge", RecipeHolder.ironIngot, r(RecipeHolder.ironPickaxe), s("ironAge2"), r(RecipeHolder.ironChestplate));

        //Mining
        ArrayList<IPage> mining = new ArrayList<IPage>();
        makePage(startingEntries, mining, "mining");

        //Useful Items
        ArrayList<IPage> usefulItems = new ArrayList<IPage>();
        makePage(startingEntries, usefulItems, "usefulItems", r(RecipeHolder.compass, RecipeHolder.clock));

        //The Endless Possibilities
        ArrayList<IPage> endlessPossibilities = new ArrayList<IPage>();
        makePage(startingEntries, endlessPossibilities, "endlessPossibilities");

        categories.add(new CategoryItemStack(startingEntries, "guide.vanilla.category.startingEntries", new ItemStack(Blocks.grass)));
    }

    private static void registerdoingEverythingEntries()
    {
        List<EntryAbstract> doingEverythingEntries = new ArrayList<EntryAbstract>();

        //Fluidity
        ArrayList<IPage> fluids = new ArrayList<IPage>();
        makePage(doingEverythingEntries, fluids, "fluids", r(RecipeHolder.bucket, RecipeHolder.boat));

        //When Things Go Boom
        ArrayList<IPage> boom = new ArrayList<IPage>();
        makePage(doingEverythingEntries, boom, "boom", r(RecipeHolder.tnt, RecipeHolder.tntMinecart));

        //Diamond & Obsidian
        ArrayList<IPage> diamondAndObsidian = new ArrayList<IPage>();
        makePage(doingEverythingEntries, diamondAndObsidian, "diamondAndObsidian", r(RecipeHolder.diamondPickaxe));

        //Enchanting
        ArrayList<IPage> enchanting = new ArrayList<IPage>();
        makePage(doingEverythingEntries, enchanting, "enchanting", r(RecipeHolder.enchantingTable, RecipeHolder.book, RecipeHolder.bookshelf, RecipeHolder.anvil));

        //The Nether
        ArrayList<IPage> nether = new ArrayList<IPage>();
        makePage(doingEverythingEntries, nether, "nether", i("netherPortalInactive", "netherPortal", "netherPortalActive"), s("nether2"));

        //Potion Master
        ArrayList<IPage> potionMaster = new ArrayList<IPage>();
        makePage(doingEverythingEntries, potionMaster, "potionMaster", r(RecipeHolder.brewingStand, RecipeHolder.emptyBottle), s("potionMaster2"));

        //Carts And Rails
        ArrayList<IPage> cartsAndRails = new ArrayList<IPage>();
        makePage(doingEverythingEntries, cartsAndRails, "cartsAndRails", r(RecipeHolder.rails, RecipeHolder.minecart, RecipeHolder.poweredRails), s("cartsAndRails2"), r(RecipeHolder.chestMinecart, RecipeHolder.furnaceMinecart, RecipeHolder.activatorRail, RecipeHolder.detectorRail));

        //Useful Decor
        ArrayList<IPage> decor = new ArrayList<IPage>();
        makePage(doingEverythingEntries, decor, "decor", r(RecipeHolder.stairs, RecipeHolder.slabs, RecipeHolder.fence, RecipeHolder.fenceGate, RecipeHolder.ladder, RecipeHolder.carpet));

        //Colors Everywhere
        ArrayList<IPage> colorsEverywhere = new ArrayList<IPage>();
        makePage(doingEverythingEntries, colorsEverywhere, "colorsEverywhere", i("rainbow", "rainbowNight"));

        //Fireworks!
        ArrayList<IPage> fireworks = new ArrayList<IPage>();
        makePage(doingEverythingEntries, fireworks, "fireworks", r(RecipeHolder.fireworkStar, RecipeHolder.firework));

        //Let It Snow
        ArrayList<IPage> snow = new ArrayList<IPage>();
        Random random = new Random();
        makePage(doingEverythingEntries, snow, "snow" + random.nextInt(2), r(RecipeHolder.snow));

        //Ender Things
        ArrayList<IPage> enderThings = new ArrayList<IPage>();
        makePage(doingEverythingEntries, enderThings, "enderThings", r(RecipeHolder.eyeOfEnder, RecipeHolder.enderChest));
        
        //Wither
        ArrayList<IPage> wither = new ArrayList<IPage>();
        makePage(doingEverythingEntries, wither, "wither", i("witherBuild"), s("wither2"));

        //Lighting A Beacon
        ArrayList<IPage> beacon = new ArrayList<IPage>();
        makePage(doingEverythingEntries, beacon, "beacon", r(RecipeHolder.beacon), i("beacon1", "beacon2", "beacon3", "beacon4"), s("beacon2"));

        //The End
        ArrayList<IPage> theEnd = new ArrayList<IPage>();
        makePage(doingEverythingEntries, theEnd, "theEnd", i("enderPortalInactive", "enderPortalActive"), s("theEnd2"));

        categories.add(new CategoryItemStack(doingEverythingEntries, "guide.vanilla.category.doingEverything", new ItemStack(Items.diamond)));
    }

    private static void registerToolsEntries()
    {
        List<EntryAbstract> toolsEntries = new ArrayList<EntryAbstract>();

        //Pickaxes, Axes, And Shovels
        ArrayList<IPage> miningTools = new ArrayList<IPage>();
        makePage(toolsEntries, miningTools, "miningTools", r(RecipeHolder.diamondPickaxe, RecipeHolder.diamondAxe, RecipeHolder.diamondShovel, RecipeHolder.diamondHoe));

        //Swords
        ArrayList<IPage> swords = new ArrayList<IPage>();
        makePage(toolsEntries, swords, "swords", r(RecipeHolder.diamondSword));

        //Fire Fishing
        ArrayList<IPage> fireFishing = new ArrayList<IPage>();
        makePage(toolsEntries, fireFishing, "fireFishing", r(RecipeHolder.flintAndSteel, RecipeHolder.fishingRod));

        //Bows And Arrows
        ArrayList<IPage> bowsAndArrows = new ArrayList<IPage>();
        makePage(toolsEntries, bowsAndArrows, "bowsAndArrows", r(RecipeHolder.bow, RecipeHolder.arrow));

        //Shears
        ArrayList<IPage> shears = new ArrayList<IPage>();
        makePage(toolsEntries, shears, "shears", r(RecipeHolder.shears));

        //Armor
        ArrayList<IPage> armor = new ArrayList<IPage>();
        makePage(toolsEntries, armor, "armor", r(RecipeHolder.diamondHelmet, RecipeHolder.diamondChestplate, RecipeHolder.diamondLeggings, RecipeHolder.diamondHelmet));

        //Carrots On Sticks
        ArrayList<IPage> carrotsOnSticks = new ArrayList<IPage>();
        makePage(toolsEntries, carrotsOnSticks, "carrotsOnSticks", r(RecipeHolder.carrotOnStick));

        //Fixing Them Up
        ArrayList<IPage> fixing = new ArrayList<IPage>();
        makePage(toolsEntries, fixing, "fixing", r(RecipeHolder.anvil));

        categories.add(new CategoryItemStack(toolsEntries, "guide.vanilla.category.tools", new ItemStack(Items.golden_sword)));
    }

    private static void registerBotanistEntries()
    {
        List<EntryAbstract> botanistEntries = new ArrayList<EntryAbstract>();

        //Everything Wood
        ArrayList<IPage> everythingWood = new ArrayList<IPage>();
        makePage(botanistEntries, everythingWood, "everythingWood", i("woods"), s("everythingWood2"), r(RecipeHolder.trapdoor, RecipeHolder.sign));

        //Natural Growth
        ArrayList<IPage> naturalGrowth = new ArrayList<IPage>();
        makePage(botanistEntries, naturalGrowth, "naturalGrowth");

        //Growing Plants
        ArrayList<IPage> growingPlants = new ArrayList<IPage>();
        makePage(botanistEntries, growingPlants, "growingPlants", i("growingPlants"), s("growingPlants2"));

        //Crops
        ArrayList<IPage> crops = new ArrayList<IPage>();
        makePage(botanistEntries, crops, "crops", r(RecipeHolder.melonSeeds, RecipeHolder.pumpkinSeeds, RecipeHolder.jackOLantern, RecipeHolder.boneMeal));

        //Other Flora
        ArrayList<IPage> otherFlora = new ArrayList<IPage>();
        makePage(botanistEntries, otherFlora, "otherFlora");

        //Tree Farm
        ArrayList<IPage> treeFarm = new ArrayList<IPage>();
        makePage(botanistEntries, treeFarm, "treeFarm");

        //Mushroomy!
        ArrayList<IPage> mushrooms = new ArrayList<IPage>();
        makePage(botanistEntries, mushrooms, "mushrooms");

        //Food In The Wild
        ArrayList<IPage> wildFood = new ArrayList<IPage>();
        makePage(botanistEntries, wildFood, "wildFood", RecipeHolder.cookedBeef, r(RecipeHolder.bread, RecipeHolder.mushroomSoup));

        //Cooking Steve!
        ArrayList<IPage> cookingSteve = new ArrayList<IPage>();
        makePage(botanistEntries, cookingSteve, "cookingSteve", r(RecipeHolder.cookies, RecipeHolder.pumpkinPie, RecipeHolder.cake, RecipeHolder.goldenApple, RecipeHolder.enchantedApple));

        categories.add(new CategoryItemStack(botanistEntries, "guide.vanilla.category.botanist", new ItemStack(Blocks.sapling)));
    }

    private static void registerRedstoneEntries()
    {
        List<EntryAbstract> redstoneEntries = new ArrayList<EntryAbstract>();

        //Redstone
        ArrayList<IPage> redstone = new ArrayList<IPage>();
        makePage(redstoneEntries, redstone, "redstone");

        //Deeper Into Redstone
        ArrayList<IPage> deeperRedstone = new ArrayList<IPage>();
        makePage(redstoneEntries, deeperRedstone, "deeperRedstone", i("redstoneDirect", "redstoneIndirect", "redstoneLength"));

        //Toggles
        ArrayList<IPage> toggles = new ArrayList<IPage>();
        makePage(redstoneEntries, toggles, "toggles", i("redstoneTorch", "redstoneTorchOff"), r(RecipeHolder.lever, RecipeHolder.button, RecipeHolder.redstoneTorch), s("toggles2"), r(RecipeHolder.daylightSensor, RecipeHolder.pressurePlate, RecipeHolder.heavyPressurePlate, RecipeHolder.redstoneBlock));

        //Conductors
        ArrayList<IPage> conductors = new ArrayList<IPage>();
        makePage(redstoneEntries, conductors, "conductors", i("repeaterOff", "repeaterOn", "repeaterInvert"), s("conductors2"), i("comparatorMaintain", "comparatorCompare", "comparatorSubtract", "comparatorMeasure"), r(RecipeHolder.redstoneComparator));

        //Recipients
        ArrayList<IPage> recipients = new ArrayList<IPage>();
        makePage(redstoneEntries, recipients, "recipients", r(RecipeHolder.hopper, RecipeHolder.piston, RecipeHolder.redstoneLamp));

        //Sneaky Sneaky...
        ArrayList<IPage> sneaky = new ArrayList<IPage>();
        makePage(redstoneEntries, sneaky, "sneaky", i("tripwire"), r(RecipeHolder.tripwireHook, RecipeHolder.trappedChest));

        //Intro To Circuits & Inverts
        ArrayList<IPage> circuitsInverts = new ArrayList<IPage>();
        makePage(redstoneEntries, circuitsInverts, "circuitsInverts", c("invert", "invert2"), s("circuitsInverts2"));

        //Clocks
        ArrayList<IPage> clocks = new ArrayList<IPage>();
        makePage(redstoneEntries, clocks, "clocks", c("repeaterClock", "comparatorClock"));

        //AND & NAND & NOT
        ArrayList<IPage> and = new ArrayList<IPage>();
        makePage(redstoneEntries, and, "and", c("and"), s("and2"), c("nand"), s("and3"), c("not"));

        //OR & NOR
        ArrayList<IPage> or = new ArrayList<IPage>();
        makePage(redstoneEntries, or, "or", c("or", "nor"));

        //XOR & XNOR
        ArrayList<IPage> xor = new ArrayList<IPage>();
        makePage(redstoneEntries, xor, "xor", c("xorBuild", "xor"));

        //Flip-Flops
        ArrayList<IPage> flipFlops = new ArrayList<IPage>();
        makePage(redstoneEntries, flipFlops, "flipFlops", c("tFlipFlop"), s("flipFlops2"), c("dFlipFlop"));

        //Latches
        ArrayList<IPage> latches = new ArrayList<IPage>();
        makePage(redstoneEntries, latches, "latches", c("rsNorLatch"), s("latches2"));

        //Useful Contraptions
        ArrayList<IPage> usefulContraptions = new ArrayList<IPage>();
        makePage(redstoneEntries, usefulContraptions, "usefulContraptions", c("randomizer"), s("usefulContraptions2"), c("bud"));

        categories.add(new CategoryItemStack(redstoneEntries, "guide.vanilla.category.redstone", new ItemStack(Items.redstone)));
    }

    private static void registerEntitiesEntries()
    {
        List<EntryAbstract> entitiesEntries = new ArrayList<EntryAbstract>();

        //Different Types Of Mobs
        ArrayList<IPage> differentTypesMobs = new ArrayList<IPage>();
        makePage(entitiesEntries, differentTypesMobs, "differentTypesMobs");

        //Farm Animals And Breeding
        ArrayList<IPage> farmAnimals = new ArrayList<IPage>();
        makePage(entitiesEntries, farmAnimals, "farmAnimals");

        //Cows
        ArrayList<IPage> cows = new ArrayList<IPage>();
        makePage(entitiesEntries, cows, "cows", i("cow", "mooshroom"));

        //Pigs
        ArrayList<IPage> pigs = new ArrayList<IPage>();
        makePage(entitiesEntries, pigs, "pigs", i("pig"));

        //Sheep
        ArrayList<IPage> sheep = new ArrayList<IPage>();
        makePage(entitiesEntries, sheep, "sheep", i("sheep", "dyedSheep"));

        //Chickens
        ArrayList<IPage> chickens = new ArrayList<IPage>();
        makePage(entitiesEntries, chickens, "chickens", i("chicken"));

        //Revolving Ocelots
        ArrayList<IPage> ocelots = new ArrayList<IPage>();
        makePage(entitiesEntries, ocelots, "ocelots", i("ocelot", "cat"));

        //Horsing Around
        ArrayList<IPage> horses = new ArrayList<IPage>();
        makePage(entitiesEntries, horses, "horses", i("horse", "donkey", "mule", "muleInventory"));

        //Selectively Breeding
        ArrayList<IPage> selectiveBreeding = new ArrayList<IPage>();
        makePage(entitiesEntries, selectiveBreeding, "selectiveBreeding");

        //Bat Squids
        ArrayList<IPage> batSquids = new ArrayList<IPage>();
        makePage(entitiesEntries, batSquids, "batSquids", i("bat", "squid"));

        //Villagers
        ArrayList<IPage> villagers = new ArrayList<IPage>();
        makePage(entitiesEntries, villagers, "villagers", i("villagers"));

        //Wolves
        ArrayList<IPage> wolves = new ArrayList<IPage>();
        makePage(entitiesEntries, wolves, "wolves", i("wolf", "dog"));

        //Spiders
        ArrayList<IPage> spiders = new ArrayList<IPage>();
        makePage(entitiesEntries, spiders, "spiders", i("spider", "caveSpider", "spiderJockey"));

        //Endermen
        ArrayList<IPage> endermen = new ArrayList<IPage>();
        makePage(entitiesEntries, endermen, "endermen", i("enderman"));

        //Zombie Pigmen
        ArrayList<IPage> zombiePigmen = new ArrayList<IPage>();
        makePage(entitiesEntries, zombiePigmen, "zombiePigmen", i("zombiePigman"));

        //Zombies
        ArrayList<IPage> zombies = new ArrayList<IPage>();
        makePage(entitiesEntries, zombies, "zombies", i("zombie", "zombieVillager"));

        //Skeletons
        ArrayList<IPage> skeletons = new ArrayList<IPage>();
        makePage(entitiesEntries, skeletons, "skeletons", i("skeleton", "witherSkeleton"));

        //Creepers
        ArrayList<IPage> creepers = new ArrayList<IPage>();
        makePage(entitiesEntries, creepers, "creepers", i("creeper", "chargedCreeper"));

        //Slimes
        ArrayList<IPage> slimes = new ArrayList<IPage>();
        makePage(entitiesEntries, slimes, "slimes", i("slime", "magmaCube"));

        //Witches
        ArrayList<IPage> witches = new ArrayList<IPage>();
        makePage(entitiesEntries, witches, "witches", i("witch"));

        //Silverfish
        ArrayList<IPage> silverfish = new ArrayList<IPage>();
        makePage(entitiesEntries, silverfish, "silverfish", i("silverfish"));

        //Blazing Ghasts
        ArrayList<IPage> blazingGhasts = new ArrayList<IPage>();
        makePage(entitiesEntries, blazingGhasts, "blazingGhasts", i("blaze", "ghast"));

        //Golems
        ArrayList<IPage> golems = new ArrayList<IPage>();
        makePage(entitiesEntries, golems, "golems", i("ironGolemBuild", "snowGolemBuild"), s("golems2"), i("ironGolem", "snowGolem"));

        //The Ender Dragon
        ArrayList<IPage> enderDragon = new ArrayList<IPage>();
        makePage(entitiesEntries, enderDragon, "enderDragon", i("EnderdragonFlying"));

        //The Wither
        ArrayList<IPage> witherBoss = new ArrayList<IPage>();
        makePage(entitiesEntries, witherBoss, "witherBoss", i("witherBuild"), s("witherBoss2"), i("witherSpawn", "wither", "witherShield"));

        categories.add(new CategoryItemStack(entitiesEntries, "guide.vanilla.category.entities", new ItemStack(Items.feather)));
    }

    private static void registerWorldEntries()
    {
        List<EntryAbstract> worldEntries = new ArrayList<EntryAbstract>();

        //Biomes
        ArrayList<IPage> biomes = new ArrayList<IPage>();
        makePage(worldEntries, biomes, "biomes");

        //Snow-Covered Biomes & Neutral Biomes
        ArrayList<IPage> snowCoveredBiomes = new ArrayList<IPage>();
        makePage(worldEntries, snowCoveredBiomes, "snowCoveredBiomes", b("frozenRiver", "icePlains", "icePlainsSpikes", "coldBeach", "coldTaiga", "coldTaigaM", "ocean", "deepOcean"), s("hills"));

        //Cold Biomes
        ArrayList<IPage> coldBiomes = new ArrayList<IPage>();
        makePage(worldEntries, coldBiomes, "coldBiomes", b("extremeHills", "extremeHillsM", "taiga", "taigaM", "megaTaiga", "megaSpruceTaiga", "extremeHills+", "extremeHills+M", "stoneBeach", "theEnd"));

        //Medium/Lush Biomes
        ArrayList<IPage> mediumLushBiomes = new ArrayList<IPage>();
        makePage(worldEntries, mediumLushBiomes, "mediumLushBiomes", b("plains", "plainsM", "sunflowerPlains", "forest", "flowerForest", "swamp", "swampM", "river", "beach", "jungle", "jungleM", "jungleEdge", "jungleEdgeM", "birchForest", "birchForestM", "birchForestHills", "birchForestHillsM", "roofedForest", "roofedForestM", "mushroomIsland", "mushroomIslandShore"));

        //Dry/Warm Biomes
        ArrayList<IPage> dryWarmBiomes = new ArrayList<IPage>();
        makePage(worldEntries, dryWarmBiomes, "dryWarmBiomes", b("desert", "desertM", "savanna", "savannaM", "mesa", "bryce", "plateau", "plateauM", "hell"));

        //World-Gen Structures
        ArrayList<IPage> structures = new ArrayList<IPage>();
        makePage(worldEntries, structures, "structures");

        //Dungeons
        ArrayList<IPage> dungeons = new ArrayList<IPage>();
        makePage(worldEntries, dungeons, "dungeons", i("dungeon", "jungleTemple", "desertTemple"));

        //Mineshafts
        ArrayList<IPage> mineshafts = new ArrayList<IPage>();
        makePage(worldEntries, mineshafts, "mineshafts", i("mineshaft"));

        //Witch's Hut
        ArrayList<IPage> witchHut = new ArrayList<IPage>();
        makePage(worldEntries, witchHut, "witchHut", i("witchHut"));

        //Villages
        ArrayList<IPage> villages = new ArrayList<IPage>();
        makePage(worldEntries, villages, "villages", i("village", "desertVillage"));

        //Strongholds
        ArrayList<IPage> strongholds = new ArrayList<IPage>();
        makePage(worldEntries, strongholds, "strongholds", i("strongholdPortalRoom"));

        //Nether Fortresses
        ArrayList<IPage> netherFortresses = new ArrayList<IPage>();
        makePage(worldEntries, netherFortresses, "netherFortresses");

        categories.add(new CategoryItemStack(worldEntries, "guide.vanilla.category.world", new ItemStack(Items.filled_map)));
    }

    private static void registerStatsEntries()
    {
        List<EntryAbstract> statsEntries = new ArrayList<EntryAbstract>();

        //Mining Stats
        ArrayList<IPage> miningStats = new ArrayList<IPage>();
        String[] oreGenL = {"Coal Ore", "Iron Ore", "Gold Ore", "Lapis Lazuli Ore", "Redstone Ore", "Diamond Ore", "Emerald Ore"};
        String[] oreGenR = {"5-52", "5-54", "5-29", "14-16", "5-12", "5-12", "5-29"};
        ItemStack[] oreGenItems = {new ItemStack(Blocks.coal_ore), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.gold_ore), new ItemStack(Blocks.lapis_ore), new ItemStack(Blocks.redstone_ore), new ItemStack(Blocks.diamond_ore), new ItemStack(Blocks.emerald_ore)};
        makePage(statsEntries, miningStats, "miningStats", l("Ore-Gen Y-Level", oreGenItems, oreGenL, oreGenR));

        //Entity Stats
        ArrayList<IPage> entityStats = new ArrayList<IPage>();
        String[] entitiesAll = {"Bat", "Chicken", "Cow/Mooshroom", "Pig", "Sheep", "Squid", "Villager", "Cave Spider", "Enderman", "Spider", "Zombie Pigman", "Blaze", "Creeper", "Ghast", "Magma Cube", "Silverfish", "Skeleton", "Slime", "Witch", "Zombie", "Horse/Donkey/Mule", "Ocelot", "Wolf", "Iron Golem", "Snow Golem", "Ender Dragon", "Wither"};
        String[] entitiesAttack = {"Cave Spider", "Enderman", "Spider", "Zombie Pigman", "Blaze", "Creeper", "Ghast", "Magma Cube", "Silverfish", "Skeleton", "Slime", "Witch", "Zombie", "Wolf", "Iron Golem", "Snow Golem", "Ender Dragon", "Wither"};
        String[] entityHealth = {"6", "4", "10", "10", "8", "10", "20", "12", "40", "16", "20", "20", "20", "10", "16/4/1", "8", "20", "16/4/1", "20", "20", "22.5", "10", "8", "100", "4", "200", "300"};
        String[] attackStrength = {"2 (Poison)", "7", "2", "9", "Fire:5, Contact:6", "Max:49", "Impact:6, Explos.:17", "6/4/3", "1", "1-4", "4/2/0", "~", "3", "4", "7-21", "0", "10", "8 (Wither)"};
        ItemStack[] entityHealthItems = {new ItemStack(Blocks.stone), new ItemStack(Items.feather), new ItemStack(Items.milk_bucket), new ItemStack(Items.porkchop), new ItemStack(Blocks.wool, 1, 15), new ItemStack(Items.dye), new ItemStack(Items.emerald), new ItemStack(Items.spider_eye), new ItemStack(Items.ender_pearl), new ItemStack(Items.string), new ItemStack(Items.gold_nugget), new ItemStack(Items.blaze_rod), new ItemStack(Items.gunpowder), new ItemStack(Items.ghast_tear), new ItemStack(Items.magma_cream), new ItemStack(Blocks.stone), new ItemStack(Items.bow), new ItemStack(Items.slime_ball), new ItemStack(Items.glass_bottle), new ItemStack(Items.rotten_flesh), new ItemStack(Items.saddle), new ItemStack(Items.fish), new ItemStack(Items.bone), new ItemStack(Items.iron_ingot), new ItemStack(Items.snowball), new ItemStack(Blocks.dragon_egg), new ItemStack(Items.nether_star)};
        ItemStack[] entityAttackItems = {new ItemStack(Items.spider_eye), new ItemStack(Items.ender_pearl), new ItemStack(Items.string), new ItemStack(Items.gold_nugget), new ItemStack(Items.blaze_rod), new ItemStack(Items.gunpowder), new ItemStack(Items.ghast_tear), new ItemStack(Items.magma_cream), new ItemStack(Blocks.stone), new ItemStack(Items.bow), new ItemStack(Items.slime_ball), new ItemStack(Items.glass_bottle), new ItemStack(Items.rotten_flesh), new ItemStack(Items.saddle), new ItemStack(Items.bone), new ItemStack(Items.iron_ingot), new ItemStack(Items.snowball), new ItemStack(Blocks.dragon_egg), new ItemStack(Items.nether_star)};
        makePage(statsEntries, entityStats, "entityStats", l("Entity Health", entityHealthItems, entitiesAll, entityHealth), l("Entity Attack Strength", entityAttackItems, entitiesAttack, attackStrength));

        //Potion Stats
        ArrayList<IPage> potionStats = new ArrayList<IPage>();
        String[] baseIngre = {"Nether Wart", "Glowstone Dust", "Redstone", "Fermented Spider Eye"};
        String[] ingre = {"Magma Cream", "Sugar", "Glistering Melon", "Spider Eye", "Ghast Tear", "Blaze Powder", "Fermented Spider Eye", "Golden Carrot", "Pufferfish"};
        String[] modifiers = {"Redstone", "Glowstone Dust", "Gunpowder", "Fermented Spider Eye"};
        String[] baseIngrePro = {"Awkward Potion", "Thick Potion", "Mundane Potion (Ext.)", "Potion of Weakness"};
        String[] ingreEff = {"Fire Resistance", "Speed", "Instant Health", "Poison", "Regneration", "Strength", "Weakness", "Night Vision", "Water Breathing"};
        String[] modifierEff = {"Increases Duration", "Increases Potency", "Turns into Splash", "Corrupts/Reverses Effect"};
        ItemStack[] baseIngr = {new ItemStack(Items.nether_wart), new ItemStack(Items.glowstone_dust), new ItemStack(Items.redstone), new ItemStack(Items.fermented_spider_eye)};
        ItemStack[] ingreStack = {new ItemStack(Items.magma_cream), new ItemStack(Items.sugar), new ItemStack(Items.speckled_melon), new ItemStack(Items.spider_eye), new ItemStack(Items.ghast_tear), new ItemStack(Items.blaze_powder), new ItemStack(Items.fermented_spider_eye), new ItemStack(Items.golden_carrot), new ItemStack(Items.fish, 1, 3)};
        ItemStack[] modifierStack = {new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust), new ItemStack(Items.gunpowder), new ItemStack(Items.fermented_spider_eye)};
        makePage(statsEntries, potionStats, "potionStats", l("Base Potions Ingredients", baseIngr, baseIngre, baseIngrePro), l("Ingredient Effects", ingreStack, ingre, ingreEff), l("Modifier Effects", modifierStack, modifiers, modifierEff));

        //Enchantment Stats
        ArrayList<IPage> enchantmentStats = new ArrayList<IPage>();
        String[] armor = {"Leather", "Chainmail", "Gold", "Iron", "Diamond"};
        String[] tool = {"Wood", "Stone", "Gold", "Iron", "Diamond"};
        String[] enchantments = {"Protection", "Fire Protection", "Feather Fall", "Blast Protection", "Projectile Protection", "Respiration", "Aqua Affinity", "Thorns", "Sharpness", "Smite", "Bane of Arthropods", "Knockback", "Fire Aspect", "Looting", "Efficiency", "Silk Touch", "Unbreaking", "Fortune", "Power", "Punch", "Flame", "Infinity", "Luck of the Sea", "Lure"};
        String[] armorLvl = {"15", "12", "25", "9", "10"};
        String[] toolLvl = {"15", "5", "22", "14", "10"};
        String[] weights = {"10", "5", "5", "2", "5", "2", "2", "2", "1", "10", "5", "5", "5", "2", "2", "10", "1", "5", "2", "10", "2", "2", "1", "2", "2"};
        String[] maxLvl = {"IV", "IV", "IV", "IV", "IV", "III", "I", "III", "V", "V", "V", "II", "II", "III", "V", "I", "III", "III", "V", "II", "I", "I", "III", "III"};
        ItemStack[] armorStack = {new ItemStack(Items.leather), new ItemStack(Blocks.fire), new ItemStack(Items.gold_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.diamond)};
        ItemStack[] toolStack = {new ItemStack(Blocks.planks), new ItemStack(Blocks.cobblestone), new ItemStack(Items.gold_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.diamond)};
        ItemStack[] enchntStack = {new ItemStack(Items.diamond_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(Items.diamond_boots), new ItemStack(Items.diamond_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(Items.diamond_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(Items.diamond_chestplate), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.bow), new ItemStack(Items.bow), new ItemStack(Items.bow), new ItemStack(Items.bow), new ItemStack(Items.fishing_rod), new ItemStack(Items.fishing_rod)};
        makePage(statsEntries, enchantmentStats, "enchantmentStats", l("Armor Enchantibility", armorStack, armor, armorLvl), l("Tool Enchantibility", toolStack, tool, toolLvl), l("Enchantment Weights", enchntStack, enchantments, weights), l("Max Enchantment Levels", enchntStack, enchantments, maxLvl));

        //Other Stats
        ArrayList<IPage> otherStats = new ArrayList<IPage>();
        String[] itemResult = {"3-4 Bread", "5-8 Melons", "5-8 Apples", "8-10 Cookies", "Shears", "Flint and Steel", "7-8 Cooked Chicken", "9-12 Arrows", "4-5 Flint", "1 Bookshelf", "1 Enchanted Book", "4-5 Glass", "1 Compass", "1 Clock", "1 Eye of Ender", "2-4 Bottle o'Enchanting", "2-4 Redstone", "2-3 Glowstone", "1 Saddle", "6-7 Cooked Porkchop", "6-7 Steak"};
        String[] itemPayment = {"1 Emerald", "1 Emerald", "1 Emerald", "1 Emerald", "3 Emeralds", "3 Emeralds", "1 Emerald", "1 Emerald", "10 Gravel, 1 Emerald", "3 Emeralds", "1 Book, 5-64 Emeralds", "1 Emerald", "10-11 Emeralds", "10-11 Emeralds", "7-10 Emeralds", "1 Emerald", "1 Emerald", "1 Emerald", "6-7 Emeralds", "1 Emerald", "1 Emerald"};
        ItemStack[] itemStacks = {new ItemStack(Items.bread, 4), new ItemStack(Items.melon, 8), new ItemStack(Items.apple, 8), new ItemStack(Items.cookie, 10), new ItemStack(Items.shears), new ItemStack(Items.flint_and_steel), new ItemStack(Items.cooked_chicken, 8), new ItemStack(Items.arrow, 12), new ItemStack(Items.flint, 5), new ItemStack(Blocks.bookshelf), new ItemStack(Items.enchanted_book), new ItemStack(Blocks.glass, 5), new ItemStack(Items.compass), new ItemStack(Items.clock), new ItemStack(Items.ender_eye), new ItemStack(Items.experience_bottle, 4), new ItemStack(Items.redstone, 4), new ItemStack(Blocks.glowstone, 3), new ItemStack(Items.saddle), new ItemStack(Items.cooked_porkchop, 7), new ItemStack(Items.cooked_beef, 7)};
        makePage(statsEntries, otherStats, "otherStats", l("Villager Trades", itemStacks, itemResult, itemPayment));

        categories.add(new CategoryItemStack(statsEntries, "guide.vanilla.category.stats", new ItemStack(Items.comparator)));
    }

    private static void makePage(List<EntryAbstract> entries, ArrayList<IPage> pages, String name, Object... others)
    {
        pages.addAll(PageHelper.pagesForLongText(replaceColors(StatCollector.translateToLocal("guide.vanilla.entry." + name))));

        if (others != null)
        {
            for (Object code : others)
            {
                if (code instanceof IPage)
                {
                    pages.add((IPage) code);
                }

                if (code instanceof Object[])
                {
                    Object[] objects = (Object[]) code;
                    for (Object object : objects)
                    {
                        pages.add((IPage) object);
                    }
                }
            }
        }
        entries.add(new EntryUniText(pages, "guide.vanilla.entryTitles." + name));
    }

    private static Object[] s(String pageName)
    {
        if (pageName != null)
        {
            return PageHelper.pagesForLongText(replaceColors(StatCollector.translateToLocal("guide.vanilla.entry." + pageName))).toArray();
        }

        return null;
    }

    private static Object[] l(String title, ItemStack[] itemStack, String[] leftText, String[] rightText)
    {
        List<IPage> pageList = new ArrayList<IPage>();
        int listMax = 12;
        if (leftText.length > listMax)
        {
            int pages = (leftText.length % listMax) > 1 ? (leftText.length / listMax) + 1 : leftText.length / listMax;
            for (int p = 0; p < pages; p++)
            {
                ItemStack[] newStacks = Arrays.copyOfRange(itemStack, p * listMax, (p + 1) * listMax < leftText.length ? (p + 1) * listMax : leftText.length - 1);
                String[] newLeftText = Arrays.copyOfRange(leftText, p * listMax, (p + 1) * listMax < leftText.length ? (p + 1) * listMax : leftText.length - 1);
                String[] newRightText = Arrays.copyOfRange(rightText, p * listMax, (p + 1) * listMax < leftText.length ? (p + 1) * listMax : leftText.length - 1);
                pageList.add(new PageList(title, newStacks, newLeftText, newRightText));
            }
        }
        else
        {
            pageList.add(new PageList(title, itemStack, leftText, rightText));
        }

        return pageList.toArray();
    }

    private static Object[] r(IRecipe... recipes)
    {
        if (recipes != null)
        {
            ArrayList<PageIRecipe> pageIRecipes = new ArrayList<PageIRecipe>();
            for (IRecipe recipe : recipes)
            {
                pageIRecipes.add(new PageIRecipe(recipe));
            }
            return pageIRecipes.toArray();
        }

        return null;
    }

    private static Object[] i(String... names)
    {
        if (names != null)
        {
            ArrayList<PageUnlocImage> images = new ArrayList<PageUnlocImage>();
            for (String name : names)
            {
                images.add(new PageUnlocImage(replaceColors(StatCollector.translateToLocal("guide.vanilla.caption." + name)), new ResourceLocation(R_LOC + name + ".png"), true));
            }

            return images.toArray();
        }

        return null;
    }

    private static Object[] b(String... names)
    {
        if (names != null)
        {
            ArrayList<PageUnlocImage> images = new ArrayList<PageUnlocImage>();
            for (String name : names)
            {
                images.add(new PageUnlocImage(replaceColors(StatCollector.translateToLocal("guide.vanilla.caption." + name)), new ResourceLocation(R_LOC + "biomes/" + name + ".png"), true));
            }

            return images.toArray();
        }

        return null;
    }

    private static Object[] c(String... names)
    {
        if (names != null)
        {
            ArrayList<PageUnlocImage> images = new ArrayList<PageUnlocImage>();
            for (String name : names)
            {
                images.add(new PageUnlocImage(replaceColors(StatCollector.translateToLocal("guide.vanilla.caption." + name)), new ResourceLocation(R_LOC + "circuits/" + name + ".png"), true));
            }

            return images.toArray();
        }

        return null;
    }

    protected static String replaceColors(String text)
    {
        if (text != null)
        {
            return text.replace("@BLD@", EnumChatFormatting.BOLD.toString())
                       .replace("@UND@", EnumChatFormatting.UNDERLINE.toString())

                       .replace("@AQA@", EnumChatFormatting.AQUA.toString())
                       .replace("@GLD@", EnumChatFormatting.GOLD.toString())
                       .replace("@DRED@", EnumChatFormatting.DARK_RED.toString())
                       .replace("@RED@", EnumChatFormatting.RED.toString())
                       .replace("@LPRP@", EnumChatFormatting.LIGHT_PURPLE.toString())
                       .replace("@PRP@", EnumChatFormatting.DARK_PURPLE.toString())
                       .replace("@GRN@", EnumChatFormatting.GREEN.toString())
                       .replace("@DGRN@", EnumChatFormatting.DARK_GREEN.toString())
                       .replace("@BLU@", EnumChatFormatting.BLUE.toString())
                       .replace("@DBLU@", EnumChatFormatting.DARK_BLUE.toString())
                       .replace("@GRY@", EnumChatFormatting.GRAY.toString())
                       .replace("@DGRY@", EnumChatFormatting.DARK_GRAY.toString())
                       .replace("@RST@", EnumChatFormatting.RESET.toString())
                       .replace("@END@", EnumChatFormatting.BLACK.toString());
        }

        return null;
    }
}
