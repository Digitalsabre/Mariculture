package joshie.mariculture.util;

import joshie.mariculture.helpers.StringHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static joshie.mariculture.lib.MaricultureInfo.MODID;
import static joshie.mariculture.util.MCTab.getTab;

public abstract class ItemFoodMC<E extends Enum<E>> extends ItemFood implements MCItem {
    protected final E[] values;
    public ItemFoodMC(Class<E> clazz) {
        this(getTab("core"), clazz);
    }

    public ItemFoodMC(CreativeTabs tab, Class<E> clazz) {
        super(0, 0.0F, false);
        values = clazz.getEnumConstants();
        setHasSubtypes(true);
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return getHealAmount(getEnumFromStack(stack));
    }

    public abstract int getHealAmount(E e);

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return getSaturationModifier(getEnumFromStack(stack));
    }

    public abstract float getSaturationModifier(E e);

    public ItemStack getStackFromEnum(E e) {
        return new ItemStack(this, 1, e.ordinal());
    }

    public E getEnumFromStack(ItemStack stack) {
        return values[Math.max(0, Math.min(values.length, stack.getItemDamage()))];
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        String unlocalized = getUnlocalizedName();
        String name = stack.getItem().getUnlocalizedName(stack);
        return StringHelper.localize(unlocalized + "." + name);
    }

    @Override
    public int getSortValue(ItemStack stack) {
        return 500;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (E e: values) {
            list.add(new ItemStack(item, 1, e.ordinal()));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerModels(Item item, String name) {
        for (int i = 0; i < values.length; i++) {
            ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(new ResourceLocation(MODID, getUnlocalizedName().replace(MODID + ".", "") + "_" + values[i].name().toLowerCase()), "inventory"));
        }
    }
}
