package push.impl

import Gender
import push.AbstractPush
import push.HasGender

class GenderPush(args: Map<String, String>) : AbstractPush(args), HasGender {
    override val gender: Gender

    init {
        gender = Gender.genderFromLiteral(args["gender"]!!)
    }
}