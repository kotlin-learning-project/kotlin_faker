package org.example.faker

import io.github.serpro69.kfaker.provider.Name


fun Name.firstNameWithNullAndEmpty(): String? = listOf("\"${this.firstName()}\"", "\"\"",null).random()
fun Name.lastNameWithNullAndEmpty(): String? = listOf("\"${this.lastName()}\"", "\"\"",null).random()
