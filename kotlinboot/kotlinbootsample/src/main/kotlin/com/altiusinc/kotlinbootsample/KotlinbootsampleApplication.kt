package com.altiusinc.kotlinbootsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class KotlinbootsampleApplication

fun main(args: Array<String>) {
	//runApplication<KotlinbootsampleApplication>(*args)
	SpringApplication.run(KotlinbootsampleApplication::class.java, *args)
}
