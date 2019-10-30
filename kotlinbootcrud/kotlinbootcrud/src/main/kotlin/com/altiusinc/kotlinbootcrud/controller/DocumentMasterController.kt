package com.altiusinc.kotlinbootcrud.controller

import com.altiusinc.kotlinbootcrud.model.DocumentMaster
import com.altiusinc.kotlinbootcrud.repository.DocumentMasterRepository

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/documentApi")
class DocumentMasterController(private val repo: DocumentMasterRepository)
  {
   @GetMapping("/documents")
   fun getAllDocuments(): List<DocumentMaster> =
	  repo.findAll()
	  
   @PostMapping("/documents")
   fun createDocument(@Valid @RequestBody docMaster: DocumentMaster): DocumentMaster =
	    repo.save(docMaster)
  @GetMapping("/documents/{docId}")
  fun getDocumentById(@PathVariable(value="docId")documentId:Int
					  ): ResponseEntity<DocumentMaster>{
	         return repo.findById(documentId).map{
				 documentMaster-> ResponseEntity.ok(documentMaster)}.orElse(ResponseEntity.notFound().build())
				}
  @PutMapping("/documents/update/{docId}",consumes=["application/json"])
  fun updateDocument(@PathVariable(value="docId")documentId:Int,
					 @Valid @RequestBody newDocMaster: DocumentMaster): ResponseEntity<DocumentMaster>
	  {
		  return repo.findById(documentId).map{
			  currentDocMaster->
			  val updatedMaster: DocumentMaster=
				  currentDocMaster.copy(documentName=newDocMaster.documentName,
					  documentType=newDocMaster.documentType,assetType=newDocMaster.assetType,
					  assetCategory=newDocMaster.assetCategory)
			  ResponseEntity.ok().body(repo.save(updatedMaster))}.orElse(ResponseEntity.notFound().build())
	 }
	  
	@DeleteMapping("/documents/delete/{docId}")
    fun deleteDocument(@PathVariable(value="docId")documentId: Int):ResponseEntity<Void>{
		return repo.findById(documentId).map{
			docMaster->repo.delete(docMaster)
			ResponseEntity<Void>(HttpStatus.OK)
		}.orElse(ResponseEntity.notFound().build())
	}
					   
	    
				  
		
	  

	  	  
	  
  }