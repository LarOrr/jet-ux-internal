package com.larorr.jet_ux_internal.services

import com.larorr.jet_ux_internal.entities.TemplateEntity
import com.larorr.jet_ux_internal.exceptions.IllegalDataException
import com.larorr.jet_ux_internal.exceptions.ResourceNotFoundException
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.springframework.test.util.ReflectionTestUtils


/**
 * Unit тесты для TemplateService
 */
class TemplateServiceTest {
    lateinit var service: TemplateService
    lateinit var repository: TemplateRepositoryMock

    @BeforeEach
    fun init() {
        repository = TemplateRepositoryMock()
        service = TemplateService(repository)
    }

    private fun createTemplate(): TemplateEntity {
        // {
        //  "templateId": "internshipRequest",
        //  "template": "Jetbrains Internship in $teamName$ team.",
        //   "recipients": ["https://httpbin.org/post"]
        // }
        return TemplateEntity(
            templateId = "internshipRequest",
            template = "\$company$ Internship in \$teamName$ team.",
            recipients = listOf("https://httpbin.org/post", "https://google.com")
        )
    }

    @Test
    fun saveTemplate() {
        val template = createTemplate()
        service.saveTemplate(template)
        assert(repository.storage.containsValue(template))
    }

    @Test
    fun `Template ID already exists`() {
        val template1 = createTemplate()
        val template2 = createTemplate()
        service.saveTemplate(template1)
        assertThrows<IllegalDataException> {
            service.saveTemplate(template2)
        }
    }

    @Test
    fun `Send Message - No Such Id`() {
        assertThrows<ResourceNotFoundException> {
            service.sendMessage("someRandomId", mapOf())
        }
    }

    private fun <T> any(): T {
        return Mockito.any<T>()
    }

    private fun anyString(): String {
        return Mockito.anyString()
    }
}