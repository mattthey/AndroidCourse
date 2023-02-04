package push

abstract class AbstractPush(args: Map<String, String>) {
    val text: String

    init {
        text = args["text"]!!
    }
}