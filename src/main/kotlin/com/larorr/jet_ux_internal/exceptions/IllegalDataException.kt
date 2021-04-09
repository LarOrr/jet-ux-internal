package com.larorr.jet_ux_internal.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class IllegalDataException(s: String?) : IllegalArgumentException(s)