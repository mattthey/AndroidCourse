package push.impl

import push.AbstractPush
import push.HasOsVersion

class TechPush(args: Map<String, String>) : AbstractPush(args), HasOsVersion {
    override val osVersion: Int
    init {
        osVersion = args["os_version"]!!.toInt()
    }
}