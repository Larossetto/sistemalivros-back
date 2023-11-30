package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Livro
import br.upf.sistemalivros.model.Usuario
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class LeituraDTO(
        val data: LocalDate,
        @field:NotNull(message = "Deve ter um leitor")
        val usuario: Usuario,
        @field:NotNull(message = "Deve ter um livro")
        val livro: Livro
)
