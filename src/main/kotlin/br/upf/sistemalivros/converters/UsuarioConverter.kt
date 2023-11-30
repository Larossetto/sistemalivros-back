package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.UsuarioDTO
import br.upf.sistemalivros.dtos.UsuarioResponseDTO
import br.upf.sistemalivros.model.Usuario
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuario(dto: UsuarioDTO): Usuario{
        return Usuario(
                nome = dto.nome,
                cidade = dto.cidade,
                telefone = dto.telefone,
                email = dto.email,
                senha = BCryptPasswordEncoder().encode(dto.senha),
                livrosLidos = listOf()
        )
    }

    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO{
        return UsuarioResponseDTO(
                id = usuario.id,
                nome = usuario.nome,
                cidade = usuario.cidade,
                telefone = usuario.telefone,
                email = usuario.email,
                livrosLidos = usuario.livrosLidos
        )
    }
}