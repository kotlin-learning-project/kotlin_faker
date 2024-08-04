package org.example.faker

import io.github.serpro69.kfaker.Faker

fun getEmployeeFakeData(faker: Faker):String ="{\n" +
        "  \"status\": \"success\",\n" +
        "  \"data\": {\n" +
        "    \"id\": ${(1..100).random()},\n" +
        "    \"employee_first_name\": ${faker.name.firstNameWithNullAndEmpty()},\n" +
        "    \"employee_last_name\": ${faker.name.lastNameWithNullAndEmpty()},\n" +
        "    \"employee_salary\": ${(300000..399999).random()},\n" +
        "    \"employee_age\": ${(20..61).random()},\n" +
        "    \"profile_image\": \"\"\n" +
        "  },\n" +
        "  \"message\": \"Successfully! Record has been fetched.\"\n" +
        "}"