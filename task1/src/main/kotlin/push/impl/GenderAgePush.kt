package push.impl

import Gender
import push.AbstractPush
import push.HasAge
import push.HasGender

class GenderAgePush(args: Map<String, String>) : AbstractPush(args), HasGender, HasAge {
    override val gender: Gender
    override val age: Int

    init {
        gender = Gender.genderFromLiteral(args["gender"]!!)
        age = args["age"]!!.toInt()
    }
}