package org.example.analys

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val logList = File("src/main/resources/mobile_1.log").useLines {
        it.toList()
    }

//    println(text)


    /*text
        .filter { it.contains("validate cached data indicate - System is currently using cache") }
        .map {
            println(it)
        }*/
    var count = 1
    var totalCacheDataDuration =0.0
    logList.forEachIndexed { index, str ->

        if (str.contains("LcsBridgeServer  --  !!!Start server called.")){
            println("COUNT: ${count++}")
            println(str)
        }
//[2024-08-09 14:26:45.340]

        if (str.contains("validate cached data indicate - System is currently using cache")) {
            println()
            println(str)
           val nextString:String= if (logList[index+2].length>150){
               logList[index+2].substring(0,150)
            }else{
                logList[index+2]
            }
            println(nextString)

            val time1  = stringToMilliseconds(str.substring(1,24))
            val time2  = stringToMilliseconds(nextString.substring(1,24))

            val cacheDataDuration = (time2-time1)/1000.0

            totalCacheDataDuration +=cacheDataDuration
            println("DURATION: ${nextString.substring(1,24)} minus ${str.substring(1,24)} = $cacheDataDuration")

        }

        if (str.contains("!!!^trackHomeScreenConstructedTime ->")){
            println(str)
            println()
            println("Total cache Data duration: ${"%.3f".format(totalCacheDataDuration)}")
            println("")
            println("--------------------------x-----------------------x------------------------x--------------")
            println("")
            totalCacheDataDuration = 0.0
        }


    }

}
fun stringToMilliseconds(dateTimeString: String): Long {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    val localDateTime = LocalDateTime.parse(dateTimeString, formatter)
    return localDateTime.toInstant(java.time.ZoneOffset.UTC).toEpochMilli()
}