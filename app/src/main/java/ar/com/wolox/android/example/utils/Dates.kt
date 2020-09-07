package ar.com.wolox.android.example.utils

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.LocalDate

class Dates {
    companion object {
        fun getDaysToDate(fromDate: String): Int {
            val formattedDate = LocalDate(DateTime.parse(fromDate))
            return Days.daysBetween(formattedDate, LocalDate.now()).days
        }
    }
}