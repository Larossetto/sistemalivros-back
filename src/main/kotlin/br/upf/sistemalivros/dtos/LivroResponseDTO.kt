package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Autor
import br.upf.sistemalivros.model.Leitura

data class LivroResponseDTO(
        val id: Long?,
        val titulo: String,
        val isbn: String,
        val autor: Autor
        //val leitores: List<Leitura>
)
