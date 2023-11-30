package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.AutorDTO
import br.upf.sistemalivros.dtos.AutorResponseDTO
import br.upf.sistemalivros.model.Autor
import org.springframework.stereotype.Component

@Component
class AutorConverter {
    fun toAutor(dto: AutorDTO): Autor{
        return Autor(
                nome = dto.nome,
                nascimento = dto.nascimento
        )
    }

    fun toAutorResponseDTO(autor: Autor): AutorResponseDTO{
        return AutorResponseDTO(
                id = autor.id,
                nome = autor.nome,
                nascimento = autor.nascimento
        )
    }
}