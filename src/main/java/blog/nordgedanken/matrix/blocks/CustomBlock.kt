package blog.nordgedanken.matrix.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material

/**
 * Created by Seine Eiligkeit on 29.06.2017.
 */
open class CustomBlock : Block {

    constructor(name: String, hardness: Float, resistance: Float) : super(Material.ROCK) {
        unlocalizedName = name
        setRegistryName(name)
        this.setHardness(hardness)
        this.setResistance(resistance)


    }

    constructor(name: String, hardness: Float, resistance: Float, mat: Material) : super(mat) {
        unlocalizedName = name
        setRegistryName(name)
        this.setHardness(hardness)
        this.setResistance(resistance)
    }
}