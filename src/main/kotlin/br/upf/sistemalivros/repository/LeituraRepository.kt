package br.upf.sistemalivros.repository

import br.upf.sistemalivros.model.Autor
import br.upf.sistemalivros.model.Leitura
import br.upf.sistemalivros.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeituraRepository: JpaRepository<Leitura, Long>{

}