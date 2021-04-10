package com.larorr.jet_ux_internal.services

import com.larorr.jet_ux_internal.entities.TemplateEntity
import com.larorr.jet_ux_internal.repositories.TemplateRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*
import kotlin.collections.HashMap

/**
 * Mock for template repository
 */
class TemplateRepositoryMock : TemplateRepository {
    var storage: MutableMap<String, TemplateEntity> = HashMap()

    override fun <S : TemplateEntity?> save(entity: S): S {
        val e = (entity as TemplateEntity)
        storage[e.templateId] = e
        return entity
    }

    override fun <S : TemplateEntity?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<TemplateEntity> {
        return Optional.ofNullable(storage[id])
    }

    override fun existsById(id: String): Boolean {
        return storage[id] != null
    }

    override fun findAll(): MutableList<TemplateEntity> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<TemplateEntity> {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<TemplateEntity> {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableList<TemplateEntity> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: TemplateEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<TemplateEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : TemplateEntity?> saveAndFlush(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun deleteInBatch(entities: MutableIterable<TemplateEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun getOne(id: String): TemplateEntity {
        TODO("Not yet implemented")
    }
}