package br.upf.sistemalivros.dtos

data class UsuarioDTO(
        val nome: String,
        val cidade: String,
        val telefone: String,
        val senha: String,
        val email: String
)
