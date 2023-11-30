package br.upf.sistemalivros.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDate

@Entity
data class Autor(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val nome: String,
        val nascimento: LocalDate,
        //@OneToMany(mappedBy = "autor")
        //val livros: List<Livro> = listOf()
)