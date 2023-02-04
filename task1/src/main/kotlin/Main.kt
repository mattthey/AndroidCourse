import filter.FilterService
import push.AbstractPush
import push.PushType

fun createSystemParameters(): SystemParameters {
    val builder = SystemParameters.Builder()
    repeat(6) { builder.applyPropertyFromStr(readln()) }
    return builder.build()
}

val filterService = FilterService()

fun main(args: Array<String>) {
    val sysParams: SystemParameters = createSystemParameters()
    var didNotShowAny = true

    val countPushes = readln().toInt()
    repeat(countPushes) {
        val countPushParameters = readln().toInt()
        val parameters = mutableMapOf<String, String>()
        repeat(countPushParameters) {
            val arg = readln().split(" ")
            parameters[arg[0]] = arg[1]
        }
        val push: AbstractPush = PushType.valueOf(parameters["type"]!!).createPush(parameters)
        if (filterService.isCorrectPush(sysParams, push)) {
            println(push.text)
            didNotShowAny = false
        }
    }

    if (didNotShowAny)
        println(-1)
}