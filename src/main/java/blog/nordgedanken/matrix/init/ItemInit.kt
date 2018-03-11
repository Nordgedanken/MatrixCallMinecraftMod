package blog.nordgedanken.matrix.init

import blog.nordgedanken.matrix.Call
import blog.nordgedanken.matrix.Logger
import blog.nordgedanken.matrix.items.CustomIngot
import blog.nordgedanken.matrix.items.DedicatedBlockItem
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent

import java.util.ArrayList

/**
 * Created by Seine Eiligkeit on 29.06.2017.
 */
object ItemInit {

    lateinit var tutorial_ingot: Item

    var itemList: ArrayList<Item> = ArrayList()

    fun prepareItems() {
        Logger.info("Item Preparation starts now")

        tutorial_ingot = CustomIngot("tutorial_ingot")

        itemList.add(tutorial_ingot)
    }
    fun addItemBlockToItems(block: Block) {
        val itemblock = ItemBlock(block)
        itemblock.registryName = block.registryName
        itemList.add(itemblock)
    }
    fun addDedicatedBlockItemToItems(item: DedicatedBlockItem) {
        val dedicatedItem: Item = item
        item.registryName = item.myBlock.registryName
        itemList.add(item)
    }


    fun registerItems(event: RegistryEvent.Register<Item>) {
        Logger.info("Item Registration starts now")
        for(item: Item in itemList) {
            Logger.info("Going to register: " + item.unlocalizedName +"...")
            event.registry.register(item)
            Logger.info("\t\tSet ModelResourceLocation to " + Call.MOD_ID + ":" + item.registryName)
            ModelLoader.setCustomModelResourceLocation(
                    item,
                    0,
                    ModelResourceLocation(Call.MOD_ID + ":" + item.unlocalizedName.substring(5))
            )
            Logger.info("Done registering: " + item.unlocalizedName +"...")
        }
        Logger.info("Done Item registration...")
    }
}