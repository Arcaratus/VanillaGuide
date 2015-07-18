package com.arc.vanillaguide;

import amerifrance.guideapi.api.abstraction.CategoryAbstract;
import amerifrance.guideapi.api.abstraction.EntryAbstract;
import amerifrance.guideapi.api.base.Book;
import amerifrance.guideapi.api.base.PageBase;
import amerifrance.guideapi.api.util.GuiHelper;
import amerifrance.guideapi.gui.GuiBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class PageList extends PageBase
{
    public ItemStack[] leftItemStack = new ItemStack[64];
    public String[] leftText = new String[64];
    public String[] rightText = new String[64];
    public int[] rightTextBackByThis = new int[64];
    public String title;

    public PageList(String title, ItemStack[] leftItemStack, String leftText[], String[] rightText)
    {
        this.title = title;
        this.leftItemStack = leftItemStack;
        this.leftText = leftText;
        this.rightText = rightText;

        for (int i = 0; i < rightText.length; i++)
        {
            this.rightTextBackByThis[i] = rightText[i].length() * 3;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void draw(Book book, CategoryAbstract category, EntryAbstract entry, int guiLeft, int guiTop, int mouseX, int mouseY, GuiBase guiBase, FontRenderer fontRenderer)
    {
        fontRenderer.setUnicodeFlag(true);
        for (int i = 0; i < leftText.length; i++)
        {
            GL11.glPushMatrix();
            GL11.glEnable(GL_BLEND);
            GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            int yLowerScale = i * 11;
            boolean isItemBlock = leftItemStack[i].getItem() instanceof ItemBlock;

            fontRenderer.drawSplitString(EnumChatFormatting.BOLD + title, guiLeft + 120 - fontRenderer.getStringWidth(title), guiTop + 12, 4 * guiBase.xSize, 0);
            fontRenderer.drawSplitString(leftText[i], guiLeft + 50, guiTop + 21 + yLowerScale, 3 * guiBase.xSize / 5, 0);
            fontRenderer.drawSplitString(rightText[i], guiLeft + 148 - rightTextBackByThis[i], guiTop + 21 + yLowerScale, 3 * guiBase.xSize / 5, 0);
            GuiHelper.drawScaledItemStack(leftItemStack[i], isItemBlock ? guiLeft + 38 : guiLeft + 37, isItemBlock ? guiTop + 18 + yLowerScale : guiTop + 18 + yLowerScale, isItemBlock ? 0.7F : 0.8F);glPopMatrix();
        }

        fontRenderer.setUnicodeFlag(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PageList that = (PageList) o;
        if (leftText != null && rightText != null ? !leftText.equals(that.leftText) && !rightText.equals(that.rightText) : that.leftText != null && that.rightText != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return leftText != null && rightText != null ? leftText.hashCode() : 0;
    }
}
