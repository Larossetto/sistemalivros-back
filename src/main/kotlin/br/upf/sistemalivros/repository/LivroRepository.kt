package br.upf.sistemalivros.repository

import br.upf.sistemalivros.model.Livro
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Pageable

@Repository
interface LivroRepository: JpaRepository<Livro, Long>{
    fun findByTitulo(tituloLivro: String, paginacao: Pageable): Page<Livro>
}