package br.upf.sistemalivros.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Leitura(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val data: LocalDate = LocalDate.now(),
        @ManyToOne
        @JsonBackReference
        val usuario: Usuario,
        @ManyToOne
        @JsonBackReference
        val livro: Livro

)
