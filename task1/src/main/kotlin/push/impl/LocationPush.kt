package push.impl

import push.AbstractPush
import push.HasExpiryDate
import push.HasLocation

class LocationPush(args: Map<String, String>) : AbstractPush(args), HasLocation, HasExpiryDate {
    override val xCoord: Float
    override val yCoord: Float
    override val radius: Int
    override val expiryDate: Long

    init {
        xCoord = args["x_coord"]!!.toFloat()
        yCoord = args["y_coord"]!!.toFloat()
        radius = args["radius"]!!.toInt()
        expiryDate = args["expiry_date"]!!.toLong()
    }
}