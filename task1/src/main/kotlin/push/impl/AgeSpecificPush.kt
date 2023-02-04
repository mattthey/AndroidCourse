package push.impl

import push.AbstractPush
import push.HasAge
import push.HasExpiryDate

class AgeSpecificPush(args: Map<String, String>) : AbstractPush(args), HasAge, HasExpiryDate {
    override val age: Int
    override val expiryDate: Long

    init {
        age = args["age"]!!.toInt()
        expiryDate = args["expiry_date"]!!.toLong()
    }
}