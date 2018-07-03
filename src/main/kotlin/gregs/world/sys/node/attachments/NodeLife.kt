package gregs.world.sys.node.attachments

interface NodeLife {

    var lifeSpan: Int
    val lifeSpanMax: Int

    fun decreaseLifeSpan() {
        lifeSpan--
    }

    fun isDead(): Boolean {
        return lifeSpan <= 0.0
    }

    fun end() {

    }
}