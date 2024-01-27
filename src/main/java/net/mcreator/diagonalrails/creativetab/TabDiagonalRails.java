
package net.mcreator.diagonalrails.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.diagonalrails.block.BlockDiagonalRail;
import net.mcreator.diagonalrails.ElementsDiagonalRails;

@ElementsDiagonalRails.ModElement.Tag
public class TabDiagonalRails extends ElementsDiagonalRails.ModElement {
	public TabDiagonalRails(ElementsDiagonalRails instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabdiagonalrails") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockDiagonalRail.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
