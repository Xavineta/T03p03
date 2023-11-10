private val Event.durationOfEvent: String
    get() {
        return if (this.duration< 60) {
            "short"
        } else {
            "long"
        }
    }

fun main() {

    val event = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        15
    );
    println(event)


    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, duration = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)
    val eventList = listOf(event1, event2, event3, event4, event5, event6)

    var contador: Int = 0
    var contadorMorning: Int = 0;
    var contadorAfternoon: Int = 0;
    var contadorEvening: Int = 0;


    eventList.forEach { eventList ->
        run {
            if (eventList.duration < 60) {
                contador++
            }
            if (eventList.daypart == Daypart.EVENING) {
                contadorEvening++;
            }
            if (eventList.daypart == Daypart.AFTERNOON) {
                contadorAfternoon++;
            }
            if (eventList.daypart == Daypart.MORNING) {
                contadorMorning++;
            }
        }
    }
    println("You have $contador shorts events")
    println("${Daypart.AFTERNOON}: $contadorAfternoon")
    println("${Daypart.EVENING}: $contadorEvening")
    println("${Daypart.MORNING}: $contadorMorning")

//    val groupedEvents = events.groupBy { it.daypart }
//    groupedEvents.forEach { (daypart, events) ->
//        println("$daypart: ${events.size} events")
//    }

    println("Last event of the day: ${eventList.last().title}")
    println("Duration of first event of the day: ${eventList[0].durationOfEvent}")

}