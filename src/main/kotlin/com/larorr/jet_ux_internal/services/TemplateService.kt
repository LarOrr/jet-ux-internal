package com.larorr.jet_ux_internal.services

import com.larorr.jet_ux_internal.entities.TemplateEntity
import com.larorr.jet_ux_internal.exceptions.IllegalDataException
import com.larorr.jet_ux_internal.exceptions.ResourceNotFoundException
import com.larorr.jet_ux_internal.repositories.TemplateRepository
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.*
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class TemplateService(val templateRepository: TemplateRepository) {
    private val log = KotlinLogging.logger {}

    fun saveTemplate(template: TemplateEntity): TemplateEntity {
        if (templateRepository.existsById(template.templateId)) {
            throw IllegalDataException("Template with such id already exists")
        }
        return templateRepository.save(template)
    }

    fun sendMessage(templateId: String, variables: Map<String, String>?) {
        val template = templateRepository.findById(templateId).orElseThrow {
            ResourceNotFoundException("No template with templateId $templateId")
        }
        var message = template.template;
        if (variables != null) {
            for (variable in variables) {
                message = message.replace(
                    "$${variable.key}$",
                    variable.value)
            }
        }
        val recipients = template.recipients
        for (recipient in recipients) {
            sendMessageToRecipient(recipient, message)
        }
    }

    private fun sendMessageToRecipient(url: String, message: String): String {
        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = JacksonSerializer()
            }
        }

        val response: String = runBlocking {
                client.request(url) {
                    method = HttpMethod.Post
                    contentType(ContentType.Application.Json)
                    body = mapOf("message" to message)
                }
            }

        log.info("Got response from $url : $response")
        return response
    }
}