package com.arc.vanillaguide;

import amerifrance.guideapi.api.GuideRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@Mod(modid = VanillaGuide.MODID, version = VanillaGuide.VERSION, name = "Vanilla Guide", dependencies = "required-after:guideapi")
public class VanillaGuide
{
    public final static String MODID = "VanillaGuide";
    public final static String VERSION = "@VERSION@";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        RecipeHolder.init();
        VanillaGuideBook.registerBook();
        MinecraftForge.EVENT_BUS.register(this);
        GameRegistry.addRecipe(new ShapelessOreRecipe(GuideRegistry.getItemStackForBook(VanillaGuideBook.vanillaGuide), new ItemStack(Items.book), new ItemStack(Items.stick)));
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        if (!event.entity.worldObj.isRemote && event.entity != null && event.entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.entity;
            NBTTagCompound tag = getModTag(player, VanillaGuide.MODID);
            if (!tag.getBoolean("hasVanillaGuide"))
            {
                if (!player.inventory.addItemStackToInventory(GuideRegistry.getItemStackForBook(VanillaGuideBook.vanillaGuide).copy())) {
                    dropItemStackInWorld(player.worldObj, player.posX, player.posY, player.posZ, (GuideRegistry.getItemStackForBook(VanillaGuideBook.vanillaGuide).copy()));
                }
                tag.setBoolean("hasVanillaGuide", true);
            }
        }
    }

    public static NBTTagCompound getModTag(EntityPlayer player, String modName) {
        NBTTagCompound tag = player.getEntityData();
        NBTTagCompound persistTag;
        if (tag.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) persistTag = tag.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
        else {
            persistTag = new NBTTagCompound();
            tag.setTag(EntityPlayer.PERSISTED_NBT_TAG, persistTag);
        }
        NBTTagCompound modTag;
        if (persistTag.hasKey(modName)) {
            modTag = persistTag.getCompoundTag(modName);
        } else {
            modTag = new NBTTagCompound();
            persistTag.setTag(modName, modTag);
        }
        return modTag;
    }

    public static EntityItem dropItemStackInWorld(World world, double x, double y, double z, ItemStack stack) {
        if (!world.isRemote) {
            float f = 0.7F;
            float d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
            float d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
            float d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5F;
            EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
            entityitem.delayBeforeCanPickup = 1;
            if (stack.hasTagCompound()) {
                entityitem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
            }
            world.spawnEntityInWorld(entityitem);
            return entityitem;
        }
        return null;
    }
}
