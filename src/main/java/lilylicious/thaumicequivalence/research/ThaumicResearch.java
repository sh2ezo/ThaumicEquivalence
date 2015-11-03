package lilylicious.thaumicequivalence.research;

import lilylicious.thaumicequivalence.config.TEConfig;
import lilylicious.thaumicequivalence.recipes.ThaumicRecipes;
import lilylicious.thaumicequivalence.utils.AspectLists;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ThaumicResearch {
    public static void registerResearch() {
        //Adds research tab
        ResearchCategories.registerCategory("TE_CATEGORY", new ResourceLocation("projecte", "textures/items/philosophers_stone.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));


        // ^ -row, v +row, < -col, > +col

        //Empty researchitem: new ResearchItem("", "TE_CATEGORY", AspectLists., 30, 0, 1, new ResourceLocation("projecte", "")).setPages(new ResearchPage("te.research_page..1"), new ResearchPage(ThaumicRecipes.)).setParents(new String[]{""}).setConcealed().registerResearchItem();

        //Root parent. Ints= Column, row, complexity
        new ResearchItem("BASICEMC", "TE_CATEGORY", AspectLists.basicEMCTheoryResearch, 0, 0, 0, new ResourceLocation("projecte", "textures/items/philosophers_stone.png")).setPages(new ResearchPage("te.research_page.BASICEMC.1"), new ResearchPage("te.research_page.BASICEMC.2"), new ResearchPage("te.research_page.BASICEMC.3"), new ResearchPage("te.research_page.BASICEMC.4")).setAutoUnlock().setRound().registerResearchItem();


        if (TEConfig.mode == 1) {
            //Left tree
            new ResearchItem("PHILOSTONE", "TE_CATEGORY", AspectLists.philoStoneResearch, -2, 1, 1, new ResourceLocation("projecte", "textures/items/philosophers_stone.png")).setPages(new ResearchPage("te.research_page.PHILOSTONE.1"), new ResearchPage(ThaumicRecipes.philoStone)).setParents(new String[]{"BASICEMC"}).setParentsHidden("INFUSION").setConcealed().registerResearchItem();
            new ResearchItem("INTERDICTION", "TE_CATEGORY", AspectLists.interdictionTorchResearch, -1, 3, 1, new ItemStack(ObjHandler.confuseTorch)).setPages(new ResearchPage("te.research_page.INTERDICTION.1"), new ResearchPage(ThaumicRecipes.interdictionTorch)).setParents(new String[]{"PHILOSTONE"}).setConcealed().registerResearchItem();
            new ResearchItem("TRANSTABLE", "TE_CATEGORY", AspectLists.transTableResearch, -4, 2, 2, new ResourceLocation("projecte", "textures/items/transmute_tablet.png")).setPages(new ResearchPage("te.research_page.TRANSTABLE.1"), new ResearchPage(ThaumicRecipes.transTable)).setParents(new String[]{"PHILOSTONE"}).setConcealed().registerResearchItem();
            new ResearchItem("TRANSMUTATIONTABLET", "TE_CATEGORY", AspectLists.transmutationTabletResearch, -6, 3, 10, new ItemStack(ObjHandler.transmutationTablet)).setPages(new ResearchPage("te.research_page.TRANSMUTATIONTABLET.1"), new ResearchPage(ThaumicRecipes.transmutationTablet)).setParents(new String[]{"TRANSTABLE"}).setParentsHidden("DARKMATTER", "INFUSION").setConcealed().registerResearchItem();


            //Middle tree
            new ResearchItem("FUELS", "TE_CATEGORY", AspectLists.fuelsResearch, 0, -2, 1, new ItemStack(ObjHandler.fuels, 1, OreDictionary.WILDCARD_VALUE)).setPages(new ResearchPage("te.research_page.FUELS.1"), new ResearchPage(ThaumicRecipes.alchCoal), new ResearchPage(ThaumicRecipes.mobiusFuel), new ResearchPage(ThaumicRecipes.aeternalisFuel)).setParents(new String[]{"BASICEMC"}).setConcealed().registerResearchItem();
            new ResearchItem("EXPLOSIVES", "TE_CATEGORY", AspectLists.explosivesResearch, 2, -3, 1, new ItemStack(ObjHandler.novaCataclysm)).setPages(new ResearchPage("te.research_page.EXPLOSIVES.1"), new ResearchPage(ThaumicRecipes.novaCatalyst), new ResearchPage(ThaumicRecipes.novaCataclysm)).setParents(new String[]{"FUELS"}).setConcealed().registerResearchItem();
            new ResearchItem("LENSES", "TE_CATEGORY", AspectLists.lensResearch, 4, -5, 1, new ItemStack(ObjHandler.lensExplosive)).setPages(new ResearchPage("te.research_page.LENSES.1"), new ResearchPage(ThaumicRecipes.destructionCatalyst), new ResearchPage(ThaumicRecipes.hyperkineticLens), new ResearchPage(ThaumicRecipes.catalyticLens)).setParents(new String[]{"EXPLOSIVES"}).setParentsHidden("DARKMATTER").setConcealed().registerResearchItem();
            new ResearchItem("DARKMATTER", "TE_CATEGORY", AspectLists.darkMatterResearch, 0, -5, 4, new ResourceLocation("projecte", "textures/items/matter/dark.png")).setPages(new ResearchPage("te.research_page.DARKMATTER.1"), new ResearchPage(ThaumicRecipes.darkMatter)).setParents(new String[]{"FUELS"}).setParentsHidden("INFUSION").setConcealed().registerResearchItem();
            new ResearchItem("REDMATTER", "TE_CATEGORY", AspectLists.redMatterResearch, 0, -9, 8, new ResourceLocation("projecte", "textures/items/matter/red.png")).setPages(new ResearchPage("te.research_page.REDMATTER.1"), new ResearchPage(ThaumicRecipes.redMatter)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("DMPEDESTAL", "TE_CATEGORY", AspectLists.dmPedestalResearch, 0, -15, 1, new ItemStack(ObjHandler.dmPedestal)).setPages(new ResearchPage("te.research_page.DMPEDESTAL.1"), new ResearchPage(ThaumicRecipes.dmPedestal)).setParents(new String[]{"REDMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("DMFURNACE", "TE_CATEGORY", AspectLists.dmFurnaceResearch, 2, -5, 1, new ItemStack(ObjHandler.dmFurnaceOn)).setPages(new ResearchPage("te.research_page.DMFURNACE.1"), new ResearchPage(ThaumicRecipes.dmFurnace)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("RMFURNACE", "TE_CATEGORY", AspectLists.rmFurnaceResearch, 1, -11, 1, new ItemStack(ObjHandler.rmFurnaceOn)).setPages(new ResearchPage("te.research_page.RMFURNACE.1"), new ResearchPage(ThaumicRecipes.rmFurnace)).setParents(new String[]{"REDMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("MERCURIALEYE", "TE_CATEGORY", AspectLists.mercurialEyeResearch, -1, -13, 1, new ItemStack(ObjHandler.mercEye)).setPages(new ResearchPage("te.research_page.MERCURIALEYE.1"), new ResearchPage(ThaumicRecipes.mercurialEye)).setParents(new String[]{"REDMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("DENSITYGEM", "TE_CATEGORY", AspectLists.densityGemResearch, 2, -5, 1, new ItemStack(ObjHandler.eternalDensity)).setPages(new ResearchPage("te.research_page.DENSITYGEM.1"), new ResearchPage(ThaumicRecipes.densityGem)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("STONES", "TE_CATEGORY", AspectLists.stoneResearch, -1, -8, 1, new ItemStack(ObjHandler.lifeStone)).setPages(new ResearchPage("te.research_page.STONES.1"), new ResearchPage(ThaumicRecipes.bodyStone), new ResearchPage(ThaumicRecipes.soulStone), new ResearchPage(ThaumicRecipes.mindStone), new ResearchPage(ThaumicRecipes.lifeStone)).setParents(new String[]{"REDMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("AMULETS", "TE_CATEGORY", AspectLists.amuletResearch, -4, -5, 1, new ItemStack(ObjHandler.everTide)).setPages(new ResearchPage("te.research_page.AMULETS.1"), new ResearchPage(ThaumicRecipes.evertide), new ResearchPage(ThaumicRecipes.volcanite)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();

            new ResearchItem("DMAXE", "TE_CATEGORY", AspectLists.dmAxeResearch, -2, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/axe.png")).setPages(new ResearchPage("te.research_page.DMAXE.1"), new ResearchPage(ThaumicRecipes.darkMatterAxe)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMHAMMER", "TE_CATEGORY", AspectLists.dmHammerResearch, -3, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/hammer.png")).setPages(new ResearchPage("te.research_page.DMHAMMER.1"), new ResearchPage(ThaumicRecipes.darkMatterHammer)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMHOE", "TE_CATEGORY", AspectLists.dmHoeResearch, -4, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/hoe.png")).setPages(new ResearchPage("te.research_page.DMHOE.1"), new ResearchPage(ThaumicRecipes.darkMatterHoe)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMSHEARS", "TE_CATEGORY", AspectLists.dmShearsResearch, -5, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/shears.png")).setPages(new ResearchPage("te.research_page.DMSHEARS.1"), new ResearchPage(ThaumicRecipes.darkMatterShears)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMSHOVEL", "TE_CATEGORY", AspectLists.dmShovelResearch, -6, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/shovel.png")).setPages(new ResearchPage("te.research_page.DMSHOVEL.1"), new ResearchPage(ThaumicRecipes.darkMatterShovel)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMSWORD", "TE_CATEGORY", AspectLists.dmSwordResearch, -7, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/sword.png")).setPages(new ResearchPage("te.research_page.DMSWORD.1"), new ResearchPage(ThaumicRecipes.darkMatterSword)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMPICK", "TE_CATEGORY", AspectLists.dmPickResearch, -8, -7, 3, new ResourceLocation("projecte", "textures/items/dm_tools/pickaxe.png")).setPages(new ResearchPage("te.research_page.DMPICK.1"), new ResearchPage(ThaumicRecipes.darkMatterPick)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMHELM", "TE_CATEGORY", AspectLists.dmHelmResearch, 2, -7, 3, new ResourceLocation("projecte", "textures/items/dm_armor/head.png")).setPages(new ResearchPage("te.research_page.DMHEAD.1"), new ResearchPage(ThaumicRecipes.darkMatterHelm)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMCHEST", "TE_CATEGORY", AspectLists.dmChestResearch, 4, -7, 3, new ResourceLocation("projecte", "textures/items/dm_armor/chest.png")).setPages(new ResearchPage("te.research_page.DMCHEST.1"), new ResearchPage(ThaumicRecipes.darkMatterChest)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMLEGS", "TE_CATEGORY", AspectLists.dmLegsResearch, 6, -7, 3, new ResourceLocation("projecte", "textures/items/dm_armor/legs.png")).setPages(new ResearchPage("te.research_page.DMLEGS.1"), new ResearchPage(ThaumicRecipes.darkMatterLegs)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("DMBOOTS", "TE_CATEGORY", AspectLists.dmBootsResearch, 8, -7, 3, new ResourceLocation("projecte", "textures/items/dm_armor/feet.png")).setPages(new ResearchPage("te.research_page.DMFEET.1"), new ResearchPage(ThaumicRecipes.darkMatterBoots)).setParents(new String[]{"DARKMATTER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RINGS", "TE_CATEGORY", AspectLists.ringsResearch, -3, -4, 4, new ResourceLocation("projecte", "textures/items/rings/iron_band.png")).setPages(new ResearchPage("te.research_page.RINGS.1"), new ResearchPage(ThaumicRecipes.ironBand), new ResearchPage(ThaumicRecipes.swiftWolf), new ResearchPage(ThaumicRecipes.harvestGoddess), new ResearchPage(ThaumicRecipes.zeroRing), new ResearchPage(ThaumicRecipes.ignitionRing), new ResearchPage(ThaumicRecipes.blackHoleBand), new ResearchPage(ThaumicRecipes.voidRing)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("TIMEWATCH", "TE_CATEGORY", AspectLists.timeWatchResearch, -5, -2, 5, new ResourceLocation("projecte", "textures/items/rings/time_watch_off.png")).setPages(new ResearchPage("te.research_page.TIMEWATCH.1"), new ResearchPage(ThaumicRecipes.timeWatch)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("KLEINSTARS", "TE_CATEGORY", AspectLists.kleinStarsResearch, -2, -2, 5, new ItemStack(ObjHandler.kleinStars, 1, 0)).setPages(new ResearchPage("te.research_page.KLEINSTARS.1"), new ResearchPage(ThaumicRecipes.kleinStarEin), new ResearchPage(ThaumicRecipes.kleinStarZwei), new ResearchPage(ThaumicRecipes.kleinStarDrei), new ResearchPage(ThaumicRecipes.kleinStarVier)).setParents(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("KLEINSPHERE", "TE_CATEGORY", AspectLists.kleinStarSphereResearch, -4, -1, 1, new ResourceLocation("projecte", "textures/items/stars/klein_star_5.png")).setPages(new ResearchPage("te.research_page.KLEINSPHERE.1"), new ResearchPage(ThaumicRecipes.kleinStarSphere)).setParents(new String[]{"KLEINSTARS"}).setConcealed().registerResearchItem();
            new ResearchItem("KLEINOMEGA", "TE_CATEGORY", AspectLists.kleinStarOmegaResearch, -6, 0, 1, new ResourceLocation("projecte", "textures/items/stars/klein_star_6.png")).setPages(new ResearchPage("te.research_page.KLEINOMEGA.1"), new ResearchPage(ThaumicRecipes.kleinStarOmega)).setParents(new String[]{"KLEINSPHERE"}).setConcealed().registerResearchItem();


            //Top middle
            new ResearchItem("RMAXE", "TE_CATEGORY", AspectLists.rmAxeResearch, -2, -19, 3, new ResourceLocation("projecte", "textures/items/rm_tools/axe.png")).setPages(new ResearchPage("te.research_page.RMAXE.1"), new ResearchPage(ThaumicRecipes.redMatterAxe)).setParents(new String[]{"REDMATTER", "DMAXE"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMHAMMER", "TE_CATEGORY", AspectLists.rmHammerResearch, -3, -18, 3, new ResourceLocation("projecte", "textures/items/rm_tools/hammer.png")).setPages(new ResearchPage("te.research_page.RMHAMMER.1"), new ResearchPage(ThaumicRecipes.redMatterHammer)).setParents(new String[]{"REDMATTER", "DMHAMMER"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMHOE", "TE_CATEGORY", AspectLists.rmHoeResearch, -4, -17, 3, new ResourceLocation("projecte", "textures/items/rm_tools/hoe.png")).setPages(new ResearchPage("te.research_page.RMHOE.1"), new ResearchPage(ThaumicRecipes.redMatterHoe)).setParents(new String[]{"REDMATTER", "DMHOE"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMSHEARS", "TE_CATEGORY", AspectLists.rmShearsResearch, -5, -16, 3, new ResourceLocation("projecte", "textures/items/rm_tools/shears.png")).setPages(new ResearchPage("te.research_page.RMSHEARS.1"), new ResearchPage(ThaumicRecipes.redMatterShears)).setParents(new String[]{"REDMATTER", "DMSHEARS"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMSHOVEL", "TE_CATEGORY", AspectLists.rmShovelResearch, -6, -15, 3, new ResourceLocation("projecte", "textures/items/rm_tools/shovel.png")).setPages(new ResearchPage("te.research_page.RMSHOVEL.1"), new ResearchPage(ThaumicRecipes.redMatterShovel)).setParents(new String[]{"REDMATTER", "DMSHOVEL"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMSWORD", "TE_CATEGORY", AspectLists.rmSwordResearch, -7, -14, 3, new ResourceLocation("projecte", "textures/items/rm_tools/sword.png")).setPages(new ResearchPage("te.research_page.RMSWORD.1"), new ResearchPage(ThaumicRecipes.redMatterSword)).setParents(new String[]{"REDMATTER", "DMSWORD"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMPICK", "TE_CATEGORY", AspectLists.rmPickResearch, -8, -13, 3, new ResourceLocation("projecte", "textures/items/rm_tools/pickaxe.png")).setPages(new ResearchPage("te.research_page.RMPICK.1"), new ResearchPage(ThaumicRecipes.redMatterPick)).setParents(new String[]{"REDMATTER", "DMPICK"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMHELM", "TE_CATEGORY", AspectLists.rmHelmResearch, 2, -13, 3, new ResourceLocation("projecte", "textures/items/rm_armor/head.png")).setPages(new ResearchPage("te.research_page.RMHEAD.1"), new ResearchPage(ThaumicRecipes.redMatterHelm)).setParents(new String[]{"REDMATTER", "DMHELM"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMCHEST", "TE_CATEGORY", AspectLists.rmChestResearch, 4, -13, 3, new ResourceLocation("projecte", "textures/items/rm_armor/chest.png")).setPages(new ResearchPage("te.research_page.RMCHEST.1"), new ResearchPage(ThaumicRecipes.redMatterChest)).setParents(new String[]{"REDMATTER", "DMCHEST"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMLEGS", "TE_CATEGORY", AspectLists.rmLegsResearch, 6, -13, 3, new ResourceLocation("projecte", "textures/items/rm_armor/legs.png")).setPages(new ResearchPage("te.research_page.RMLEGS.1"), new ResearchPage(ThaumicRecipes.redMatterLegs)).setParents(new String[]{"REDMATTER", "DMLEGS"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("RMBOOTS", "TE_CATEGORY", AspectLists.rmBootsResearch, 8, -13, 3, new ResourceLocation("projecte", "textures/items/rm_armor/feet.png")).setPages(new ResearchPage("te.research_page.RMFEET.1"), new ResearchPage(ThaumicRecipes.redMatterBoots)).setParents(new String[]{"REDMATTER", "DMBOOTS"}).setSecondary().setConcealed().registerResearchItem();
            new ResearchItem("GEMHEAD", "TE_CATEGORY", AspectLists.gemHelmResearch, 2, -15, 1, new ResourceLocation("projecte", "textures/items/gem_armor/head.png")).setPages(new ResearchPage("te.research_page.GEMHEAD.1"), new ResearchPage(ThaumicRecipes.gemHead)).setParents(new String[]{"RMHELM"}).setParentsHidden(new String[]{"KLEINOMEGA"}).setConcealed().registerResearchItem();
            new ResearchItem("GEMCHEST", "TE_CATEGORY", AspectLists.gemChestResearch, 4, -15, 1, new ResourceLocation("projecte", "textures/items/gem_armor/chest.png")).setPages(new ResearchPage("te.research_page.GEMCHEST.1"), new ResearchPage(ThaumicRecipes.gemChest)).setParents(new String[]{"RMCHEST"}).setParentsHidden(new String[]{"KLEINOMEGA"}).setConcealed().registerResearchItem();
            new ResearchItem("GEMLEGS", "TE_CATEGORY", AspectLists.gemLegsResearch, 6, -15, 1, new ResourceLocation("projecte", "textures/items/gem_armor/legs.png")).setPages(new ResearchPage("te.research_page.GEMLEGS.1"), new ResearchPage(ThaumicRecipes.gemLegs)).setParents(new String[]{"RMLEGS"}).setParentsHidden(new String[]{"KLEINOMEGA"}).setConcealed().registerResearchItem();
            new ResearchItem("GEMBOOTS", "TE_CATEGORY", AspectLists.gemBootsResearch, 8, -15, 1, new ResourceLocation("projecte", "textures/items/gem_armor/feet.png")).setPages(new ResearchPage("te.research_page.GEMFEET.1"), new ResearchPage(ThaumicRecipes.gemBoots)).setParents(new String[]{"RMBOOTS"}).setParentsHidden(new String[]{"KLEINOMEGA"}).setConcealed().registerResearchItem();
            new ResearchItem("MORNINGSTAR", "TE_CATEGORY", AspectLists.morningstarResearch, -7, -18, 1, new ResourceLocation("projecte", "textures/items/rm_tools/morning_star.png")).setPages(new ResearchPage("te.research_page.MORNINGSTAR.1"), new ResearchPage(ThaumicRecipes.morningStar)).setParents(new String[]{"RMHAMMER", "RMPICK", "RMSHOVEL"}).setConcealed().registerResearchItem();
            new ResearchItem("KATAR", "TE_CATEGORY", AspectLists.katarResearch, -9, -20, 1, new ResourceLocation("projecte", "textures/items/rm_tools/katar.png")).setPages(new ResearchPage("te.research_page.KATAR.1"), new ResearchPage(ThaumicRecipes.katar)).setParents(new String[]{"RMHOE", "RMSHEARS", "RMAXE", "RMSWORD"}).setConcealed().registerResearchItem();
            new ResearchItem("ARCANARING", "TE_CATEGORY", AspectLists.arcanaRingResearch, -5, -4, 1, new ResourceLocation("projecte", "textures/items/rings/arcana_0_on.png")).setPages(new ResearchPage("te.research_page.ARCANARING.1"), new ResearchPage(ThaumicRecipes.arcanaRing)).setParents(new String[]{"RINGS"}).setConcealed().registerResearchItem();


            //Right tree

            new ResearchItem("COVALENCE", "TE_CATEGORY", AspectLists.covalenceResearch, 2, 1, 1, new ResourceLocation("projecte", "textures/items/covalence_dust/medium.png")).setPages(new ResearchPage("te.research_page.COVALENCE.1"), new ResearchPage(ThaumicRecipes.covalenceLow), new ResearchPage(ThaumicRecipes.covalenceMed), new ResearchPage(ThaumicRecipes.covalenceHigh)).setParents(new String[]{"BASICEMC"}).setConcealed().registerResearchItem();
            new ResearchItem("DIVININERS", "TE_CATEGORY", AspectLists.divinerResearch, 2, 3, 1, new ItemStack(ObjHandler.dRod3)).setPages(new ResearchPage("te.research_page.DIVININERS.1"), new ResearchPage(ThaumicRecipes.lowDiviner), new ResearchPage(ThaumicRecipes.medDiviner), new ResearchPage(ThaumicRecipes.highDiviner)).setParents(new String[]{"COVALENCE"}).setParentsHidden("INFUSION").setConcealed().registerResearchItem();
            new ResearchItem("REPAIRTALISMAN", "TE_CATEGORY", AspectLists.repairResearch, 5, 2, 1, new ResourceLocation("projecte", "textures/items/repair_talisman.png")).setPages(new ResearchPage("te.research_page.REPAIRTALISMAN.1"), new ResearchPage(ThaumicRecipes.repairTalisman)).setParents(new String[]{"COVALENCE"}).setParentsHidden("INFUSION").setConcealed().registerResearchItem();
            new ResearchItem("ALCHEMICALCHEST", "TE_CATEGORY", AspectLists.alchChestResearch, 6, 3, 1, new ItemStack(ObjHandler.alchChest)).setPages(new ResearchPage("te.research_page.ALCHEMICALCHEST.1"), new ResearchPage(ThaumicRecipes.alchemicalChest)).setParents(new String[]{"COVALENCE"}).setParentsHidden("INFUSION").setConcealed().registerResearchItem();
            new ResearchItem("ALCHEMYBAG", "TE_CATEGORY", AspectLists.whiteAlchBagResearch, 9, 3, 1, new ItemStack(ObjHandler.alchBag, 1, 0)).setPages(new ResearchPage("te.research_page.ALCHEMYBAG.1"), new ResearchPage(ThaumicRecipes.whiteAlchBag)).setParents(new String[]{"ALCHEMICALCHEST"}).setConcealed().registerResearchItem();
            new ResearchItem("ENERGYCONDENSER", "TE_CATEGORY", AspectLists.energyCondenserResearch, 7, 6, 1, new ItemStack(ObjHandler.condenser)).setPages(new ResearchPage("te.research_page.ENERGYCONDENSER.1"), new ResearchPage(ThaumicRecipes.energyCondenser)).setParents(new String[]{"ALCHEMICALCHEST"}).setConcealed().registerResearchItem();
            new ResearchItem("CONDENSERMK2", "TE_CATEGORY", AspectLists.energCondenserMk2Research, 6, 8, 1, new ItemStack(ObjHandler.condenserMk2)).setPages(new ResearchPage("te.research_page.CONDENSERMK2.1"), new ResearchPage(ThaumicRecipes.energCondenserMk2)).setParents(new String[]{"ENERGYCONDENSER"}).setConcealed().registerResearchItem();

            //Bottom right

            new ResearchItem("POWERFLOWERS", "TE_CATEGORY", AspectLists.powerFlowerResearch, 9, 7, 1, new ItemStack(ObjHandler.energyCollector)).setPages(new ResearchPage("te.research_page.POWERFLOWERS.1"), new ResearchPage(ThaumicRecipes.collectorMk1), new ResearchPage(ThaumicRecipes.relayMk1)).setParents(new String[]{"ENERGYCONDENSER"}).setConcealed().registerResearchItem();
            new ResearchItem("MK2", "TE_CATEGORY", AspectLists.mk2Research, 10, 9, 1, new ItemStack(ObjHandler.collectorMK2)).setPages(new ResearchPage("te.research_page.MK2.1"), new ResearchPage(ThaumicRecipes.collectorMk2), new ResearchPage(ThaumicRecipes.relayMk2)).setParents(new String[]{"POWERFLOWERS"}).setParentsHidden(new String[]{"DARKMATTER"}).setConcealed().registerResearchItem();
            new ResearchItem("MK3", "TE_CATEGORY", AspectLists.mk3Research, 12, 11, 1, new ItemStack(ObjHandler.collectorMK3)).setPages(new ResearchPage("te.research_page.MK3.1"), new ResearchPage(ThaumicRecipes.collectorMk3), new ResearchPage(ThaumicRecipes.relayMk3)).setParents(new String[]{"MK2"}).setParentsHidden(new String[]{"REDMATTER"}).setConcealed().registerResearchItem();

        }
    }


}
