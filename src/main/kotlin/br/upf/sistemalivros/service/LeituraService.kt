package br.upf.sistemalivros.service

import br.upf.sistemalivros.converters.LeituraConverter
import br.upf.sistemalivros.dtos.LeituraDTO
import br.upf.sistemalivros.dtos.LeituraResponseDTO
import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.repository.LeituraRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val LEITURA_NOT_FOUND_MESSAGE = "Leitura não encontrado!"
@Service
class LeituraService(
        private val repository: LeituraRepository,
        private val converter: LeituraConverter) {

    fun listar(): List<LeituraResponseDTO> {
        return repository.findAll().map(converter::toLeituraResponseDTO)
    }

    fun buscarPorId(id: Long): LeituraResponseDTO {
        val leitura = repository.findById(id)
                .orElseThrow{ NotFoundException(LEITURA_NOT_FOUND_MESSAGE) }
        return converter.toLeituraResponseDTO(leitura)
    }

    fun cadastrar(dto: LeituraDTO): LeituraResponseDTO {
        return converter.toLeituraResponseDTO(
                repository.save(converter.toLeitura(dto)))
    }

    fun atualizar(id: Long, dto: LeituraDTO): LeituraResponseDTO {
        val livro = repository.findById(id)
                .orElseThrow{ NotFoundException(LEITURA_NOT_FOUND_MESSAGE) }
                .copy(
                        data = dto.data,
                        usuario = dto.usuario,
                        livro = dto.livro
                )
        return converter.toLeituraResponseDTO(repository.save(livro))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}