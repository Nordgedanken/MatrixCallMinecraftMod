package blog.nordgedanken.matrix.blocks

import net.minecraft.creativetab.CreativeTabs

/**
 * Created by Seine Eiligkeit on 29.06.2017.
 */
class CustomOre(name: String, hardness: Float, resistance: Float, harvestLevel: Int) : CustomBlock(name, hardness, resistance) {
    init {
        setHarvestLevel("pickaxe", harvestLevel)
        setCreativeTab(CreativeTabs.MISC)
    }
}