package br.upf.sistemalivros.service

import br.upf.sistemalivros.converters.LivroConverter
import br.upf.sistemalivros.dtos.LivroDTO
import br.upf.sistemalivros.dtos.LivroResponseDTO
import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.repository.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable

private const val LIVRO_NOT_FOUND_MESSAGE = "Livro não encontrado!"
@Service
class LivroService(
        private val repository: LivroRepository,
        private val converter: LivroConverter) {

    fun listar(
        tituloLivro: String?,
        paginacao: Pageable): Page<LivroResponseDTO> {
        val livros = if (tituloLivro == null){
            repository.findAll(paginacao)
        } else {
            repository.findByTitulo(tituloLivro, paginacao)
        }
        return livros.map(converter::toLivroResponseDTO)
    }

    fun buscarPorId(id: Long): LivroResponseDTO {
        val livro = repository.findById(id)
                .orElseThrow{NotFoundException(LIVRO_NOT_FOUND_MESSAGE)}
        return converter.toLivroResponseDTO(livro)
    }

    fun cadastrar(dto: LivroDTO): LivroResponseDTO {
        return converter.toLivroResponseDTO(
                repository.save(converter.toLivro(dto)))
    }

    fun atualizar(id: Long, dto: LivroDTO): LivroResponseDTO {
        val livro = repository.findById(id)
                .orElseThrow{NotFoundException(LIVRO_NOT_FOUND_MESSAGE)}
                .copy(
                        titulo = dto.titulo,
                        isbn = dto.isbn,
                        autor = dto.autor
                )
        return converter.toLivroResponseDTO(repository.save(livro))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}