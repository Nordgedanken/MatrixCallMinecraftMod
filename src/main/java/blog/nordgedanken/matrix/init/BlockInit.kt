package blog.nordgedanken.matrix.init

import blog.nordgedanken.matrix.Logger
import blog.nordgedanken.matrix.blocks.CustomOre
import net.minecraft.block.Block
import net.minecraftforge.event.RegistryEvent

/**
 * Created by Seine Eiligkeit on 29.06.2017.
 */
object BlockInit {

    lateinit var tutorial_ore: Block

    var blockList: ArrayList<Block> = ArrayList()

    fun prepareBlocks() {
        Logger.info("Block Preparation starts now")

        tutorial_ore = CustomOre("tutorial_ore",2.0F,4.0F,2)

        ItemInit.addItemBlockToItems(tutorial_ore)

        blockList.add(tutorial_ore)
    }

    fun registerBlocks(event: RegistryEvent.Register<Block> ){
        Logger.info("Block Registration starts now")
        for(block: Block in blockList){
            Logger.info("Going to register: " + block.unlocalizedName +"...")
            event.registry.register(block)

        }
        Logger.info("Done Item registration...")
    }
}