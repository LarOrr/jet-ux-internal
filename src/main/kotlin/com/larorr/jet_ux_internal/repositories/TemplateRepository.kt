package com.larorr.jet_ux_internal.repositories

import com.larorr.jet_ux_internal.entities.TemplateEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TemplateRepository : JpaRepository<TemplateEntity, String> {

}