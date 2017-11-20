package com.toricor.training

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TrainingApplication

// added comment
fun main(args: Array<String>) {
    SpringApplication.run(TrainingApplication::class.java, *args)
}
