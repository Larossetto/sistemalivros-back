package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Leitura

data class UsuarioResponseDTO(
        val id: Long? = null,
        val nome: String,
        val cidade: String,
        val telefone: String,
        val email: String,
        val livrosLidos: List<Leitura>
)
