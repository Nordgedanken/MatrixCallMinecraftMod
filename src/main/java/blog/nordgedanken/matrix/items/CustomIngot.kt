package blog.nordgedanken.matrix.items


import net.minecraft.creativetab.CreativeTabs

/**
 * Created by Seine Eiligkeit on 29.06.2017.
 */
class CustomIngot(name: String) : net.minecraft.item.Item() {

    init {
        unlocalizedName = name
        setRegistryName(name)
        creativeTab = CreativeTabs.MATERIALS
    }
}