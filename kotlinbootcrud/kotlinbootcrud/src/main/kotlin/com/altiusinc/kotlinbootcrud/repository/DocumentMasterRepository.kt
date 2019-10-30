package com.altiusinc.kotlinbootcrud.repository

import com.altiusinc.kotlinbootcrud.model.DocumentMaster
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentMasterRepository : JpaRepository<DocumentMaster, Int>