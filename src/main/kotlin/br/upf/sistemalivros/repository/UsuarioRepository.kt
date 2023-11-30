package br.upf.sistemalivros.repository

import br.upf.sistemalivros.model.Autor
import br.upf.sistemalivros.model.Usuario
import jakarta.validation.constraints.Email
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long>{
    fun findByEmail(email: String): UserDetails
}