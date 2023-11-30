package br.upf.sistemalivros.dtos

import java.time.LocalDate

data class AutorResponseDTO(
        val id: Long?,
        val nome: String,
        val nascimento: LocalDate
)
