data class SystemParameters(
    val time: Long,
    val age: Int,
    val gender: Gender,
    val osVersion: Int,
    val coordX: Float,
    val  coordY: Float
) {
    class Builder(
        private var time: Long? = null,
        private var age: Int? = null,
        private var gender: Gender? = null,
        private var osVersion: Int? = null,
        private var coordX: Float? = null,
        private var coordY: Float? = null
    ) {
        fun applyPropertyFromStr(str: String) {
            val splitedStr: List<String> = str.split(" ")
            val propertyName: String = splitedStr[0]
            val value: String = splitedStr[1]
            when (propertyName) {
                "time" -> this.time = value.toLong()
                "age" -> this.age = value.toInt()
                "gender" -> this.gender = Gender.genderFromLiteral(value)
                "os_version" -> this.osVersion = value.toInt()
                "x_coord" -> this.coordX = value.toFloat()
                "y_coord" -> this.coordY = value.toFloat()
                else -> throw RuntimeException("Unknow property $propertyName")
            }
        }

        fun build(): SystemParameters = SystemParameters(time!!, age!!, gender!!, osVersion!!, coordX!!, coordY!!)
    }
}