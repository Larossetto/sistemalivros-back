package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Livro
import br.upf.sistemalivros.model.Usuario
import java.time.LocalDate

data class LeituraResponseDTO(
        val id: Long?,
        val data: LocalDate,
        val usuario: Usuario,
        val livro: Livro
)
