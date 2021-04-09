package com.larorr.jet_ux_internal.entities

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class TemplateEntity(@Id var templateId: String,
               var template: String,
               @ElementCollection
               var recipients: List<String>
)