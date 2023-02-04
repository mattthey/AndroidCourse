enum class Gender(private val literal: String) {
    MALE("m"),
    FEMALE("f");

    companion object {
        fun genderFromLiteral(literal: String): Gender {
            return values().find { g -> g.literal == literal } ?: throw RuntimeException("Can't find GENDER for literal $literal")
        }
    }
}