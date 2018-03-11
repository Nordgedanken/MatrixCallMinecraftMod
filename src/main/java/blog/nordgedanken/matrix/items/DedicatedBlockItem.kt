package blog.nordgedanken.matrix.items

import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock

/**
 * Created by Seine Eiligkeit on 10.07.2017.
 */
class DedicatedBlockItem(block: Block) : ItemBlock(block) {

    val myBlock: Block
        get() = this.block

    init {
        this.creativeTab = CreativeTabs.MISC
    }

    companion object {

        fun provideInstance(block: Block): Item {
            return DedicatedBlockItem(block)
        }
    }
}