package br.upf.sistemalivros.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
data class Livro(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val titulo: String,
        val isbn: String,
        @ManyToOne
        val autor: Autor,
        @OneToMany(mappedBy = "livro")
        @JsonManagedReference
        val leitores: List<Leitura> = listOf()

)
