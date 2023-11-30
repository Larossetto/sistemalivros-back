package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.LeituraDTO
import br.upf.sistemalivros.dtos.LeituraResponseDTO
import br.upf.sistemalivros.model.Leitura
import org.springframework.stereotype.Component

@Component
class LeituraConverter {
    fun toLeitura(dto: LeituraDTO): Leitura{
        return Leitura(
                data = dto.data,
                usuario = dto.usuario,
                livro = dto.livro
        )
    }

    fun toLeituraResponseDTO(leitura: Leitura): LeituraResponseDTO{
        return LeituraResponseDTO(
                id = leitura.id,
                data = leitura.data,
                livro = leitura.livro,
                usuario = leitura.usuario
        )
    }
}