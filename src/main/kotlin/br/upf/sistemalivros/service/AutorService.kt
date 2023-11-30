package br.upf.sistemalivros.service

import br.upf.sistemalivros.converters.AutorConverter
import br.upf.sistemalivros.dtos.AutorDTO
import br.upf.sistemalivros.dtos.AutorResponseDTO
import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.repository.AutorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val AUTOR_NOT_FOUND_MESSAGE = "Autor não encontrado!"

@Service
class AutorService(
        private val repository:AutorRepository,
        private val converter: AutorConverter) {

    fun listar(
            nomeAutor: String?,
            paginacao: Pageable): Page<AutorResponseDTO>{
        val autores = if (nomeAutor ==null){
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeAutor,paginacao)
        }
        return autores.map(converter::toAutorResponseDTO)
    }

    fun buscarPorId(id: Long): AutorResponseDTO{
        val autor = repository.findById(id)
                .orElseThrow{NotFoundException(AUTOR_NOT_FOUND_MESSAGE)}
        return converter.toAutorResponseDTO(autor)
    }

    fun cadastrar(dto: AutorDTO): AutorResponseDTO{
        return converter.toAutorResponseDTO(
                repository.save(converter.toAutor(dto)))
    }

    fun atualizar(id: Long, dto: AutorDTO): AutorResponseDTO {
        val autor = repository.findById(id)
                .orElseThrow{NotFoundException(AUTOR_NOT_FOUND_MESSAGE)}
                .copy(
                        nome = dto.nome,
                        nascimento = dto.nascimento
                )
        return converter.toAutorResponseDTO(repository.save(autor))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}