package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.LivroDTO
import br.upf.sistemalivros.dtos.LivroResponseDTO
import br.upf.sistemalivros.model.Livro
import org.springframework.stereotype.Component

@Component
class LivroConverter {
    fun toLivro(dto: LivroDTO): Livro{
        return Livro(
                titulo = dto.titulo,
                isbn = dto.isbn,
                autor = dto.autor
                //leitores = listOf()
        )
    }

    fun toLivroResponseDTO(livro: Livro): LivroResponseDTO{
        return LivroResponseDTO(
                id = livro.id,
                titulo = livro.titulo,
                isbn = livro.isbn,
                autor = livro.autor
                //leitores = livro.leitores
        )
    }
}