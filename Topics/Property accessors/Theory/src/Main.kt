import kotlinx.datetime.DateTimePeriod
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import kotlin.time.Duration

// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    val instant1 = Instant.parse("2100-01-01T00:00:00Z")
    val instant2 = Instant.parse("2105-07-09T15:23:40Z")

    val duration: Duration = instant2 - instant1
    println(duration)                                             // 2015d 15h 23m 40s
    println(duration.inWholeDays)                                 // 2015
    println(duration.inWholeHours)                                // 48375

    println( instant1.periodUntil(instant2, TimeZone.UTC) )       // P5Y6M8DT15H23M40S
    println( instant1.periodUntil(instant2, TimeZone.UTC).days )
}
