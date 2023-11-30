package br.upf.sistemalivros.repository

import br.upf.sistemalivros.model.Autor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository: JpaRepository<Autor, Long>{
    fun findByNome(nomeAutor: String, paginacao: Pageable): Page<Autor>
}