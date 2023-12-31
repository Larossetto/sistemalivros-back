package br.upf.sistemalivros.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class Usuario(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val nome: String,
        val cidade: String,
        val telefone: String,
        val senha: String,
        val email: String,
        @Enumerated(value = EnumType.STRING)
        val role: UserRole = UserRole.USER,
        @JsonManagedReference
        @OneToMany(mappedBy = "usuario")
        val livrosLidos: List<Leitura> = listOf()
) : UserDetails {
        override fun getAuthorities(): MutableList<SimpleGrantedAuthority> =
                if (role == UserRole.ADMIN) mutableListOf(
                        SimpleGrantedAuthority("ROLE_ADMIN"),
                        SimpleGrantedAuthority("ROLE_USER")
                )
                else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))

        override fun getPassword() = senha
        override fun getUsername()= email
        override fun isAccountNonExpired () = true
        override fun isAccountNonLocked () = true
        override fun isCredentialsNonExpired () = true
        override fun isEnabled() = true
}
