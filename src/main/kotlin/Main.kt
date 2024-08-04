package org.example

import io.github.serpro69.kfaker.Faker
import org.example.faker.getEmployeeFakeData
import java.io.File
import java.nio.file.Paths

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")


    val resources_path = "${Paths.get("").toAbsolutePath()}/src/main/resources/"

    val fileName = "employee_faker"

    println(resources_path)


    for (i in 1..3) {
        val file = "$resources_path/${fileName}_$i.json"
        File(file)
            .printWriter()
            .use { out -> out.println(getEmployeeFakeData(Faker())) }

        println(file)
    }
}