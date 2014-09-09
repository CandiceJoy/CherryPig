package othlon.cherrypig.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import othlon.cherrypig.CherryPig;

import java.util.List;

/**
 * Created by Jen on 30/05/14.
 */
public class CPCherryLog extends BlockLog {
    @SideOnly(Side.CLIENT)
    IIcon logIcon;
    IIcon logIconTopBtm;

    public CPCherryLog() {

        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeWood);
        this.setBlockName("CherryPig Wood");
        this.setCreativeTab(CherryPig.tabCherryPig);

    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        //noinspection unchecked
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    } //nope

    @Override
    public void registerBlockIcons(IIconRegister thisdude) {
        logIcon       = thisdude.registerIcon("cherrypig:cherrypig_treebark");
        logIconTopBtm = thisdude.registerIcon("cherrypig:cherrypig_treelog");
    }


    //@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0 | side == 1) {
            return logIconTopBtm;
        } else {
            return logIcon;
        }
    }

    @Override
        @SideOnly(Side.CLIENT)
        protected IIcon getSideIcon(int meta)
    {
        return this.logIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int meta)
    {
        return this.logIconTopBtm;
    }

    @Override
    public int onBlockPlaced( World world, int x, int y, int z, int side, float hitx, float hity, float hitz, int meta)
    {
        byte orientation = 0;

        switch(side)
        {
            case 0:
            case 1:
                orientation = 0;
                break;

            case 2:
            case 3:
                orientation = 8;
                break;
            case 4:
            case 5:
                orientation = 4;
        }
        return orientation;
    }
}
