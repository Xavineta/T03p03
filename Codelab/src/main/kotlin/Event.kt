data class Event(
    var title: String,
    var description: String? = null,
    var daypart: Daypart,
    var duration: Int
) {

}

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}
