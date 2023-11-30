package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Autor
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class LivroDTO(
        @field:NotEmpty(message = "Livro sempre deve ter um título")
        val titulo: String,
        @field:NotNull(message = "Deve ter um ISBN")
        val isbn: String,
        @field:NotNull(message = "Deve ter um autor")
        val autor: Autor
)
