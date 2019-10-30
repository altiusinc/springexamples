package com.altiusinc.kotlinbootcrud.model

import javax.persistence.Entity;
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class DocumentMaster (
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	val docId:Int = 0,
    @get: NotBlank
    val documentName: String=" ",
	@get: NotBlank
	val documentType: String=" ",
	@get: NotBlank
	val assetType: String=" ",
	@get: NotBlank
	val assetCategory: String=" "
	

)