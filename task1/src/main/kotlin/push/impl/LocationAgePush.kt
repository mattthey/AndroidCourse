package push.impl

import push.AbstractPush
import push.HasAge
import push.HasLocation

class LocationAgePush(args: Map<String, String>) : AbstractPush(args), HasLocation, HasAge {
    override val xCoord: Float
    override val yCoord: Float
    override val radius: Int
    override val age: Int

    init {
        xCoord = args["x_coord"]!!.toFloat()
        yCoord = args["y_coord"]!!.toFloat()
        radius = args["radius"]!!.toInt()
        age = args["age"]!!.toInt()
    }
}