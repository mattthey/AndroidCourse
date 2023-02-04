package push

import push.impl.*

enum class PushType(val createPush: (Map<String, String>) -> AbstractPush) {
    LocationPush(::LocationPush),
    AgeSpecificPush(::AgeSpecificPush),
    TechPush(::TechPush),
    LocationAgePush(::LocationAgePush),
    GenderAgePush(::GenderAgePush),
    GenderPush(::GenderPush)
}