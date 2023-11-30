package br.upf.sistemalivros.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class AutorDTO(
        @field:NotEmpty(message = "Autor sempre deve ter um nome")
        val nome: String,
        @field:NotNull(message = "Deve ter uma data de nascimento")
        val nascimento: LocalDate
)
