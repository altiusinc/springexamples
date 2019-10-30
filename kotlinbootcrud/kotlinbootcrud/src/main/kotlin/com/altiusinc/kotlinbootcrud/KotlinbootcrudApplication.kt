package com.altiusinc.kotlinbootcrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.SpringApplication;

@SpringBootApplication
class KotlinbootcrudApplication

fun main(args: Array<String>) {
	//runApplication<KotlinbootcrudApplication>(*args)
	SpringApplication.run(KotlinbootcrudApplication::class.java, *args)
}
