package com.larorr.jet_ux_internal.controller

import com.larorr.jet_ux_internal.dto.SendMessageDTO
import com.larorr.jet_ux_internal.entities.TemplateEntity
import com.larorr.jet_ux_internal.services.TemplateService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/templates")
class TemplateController(
    val templateService: TemplateService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTemplate(@RequestBody template: TemplateEntity): TemplateEntity {
        return templateService.saveTemplate(template)
    }

    // С точки зрения REST лучше сделать "/<templateID>/sendMessage", но это будет протеворечить условию
    @PostMapping("/sendMessage")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun sendMessage(@RequestBody sendMessageDTO: SendMessageDTO) {
        templateService.sendMessage(sendMessageDTO.templateId, sendMessageDTO.variables)
    }
}