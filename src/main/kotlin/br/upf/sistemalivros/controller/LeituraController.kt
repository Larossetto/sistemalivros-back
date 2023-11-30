package br.upf.sistemalivros.controller

import br.upf.sistemalivros.dtos.LeituraDTO
import br.upf.sistemalivros.dtos.LeituraResponseDTO
import br.upf.sistemalivros.service.LeituraService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/leituras")
class LeituraController (val service: LeituraService) {

    @GetMapping
    fun listar(): List<LeituraResponseDTO>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): LeituraResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: LeituraDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<LeituraResponseDTO> {
        val leituraResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/leituras/${leituraResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(leituraResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id:Long,
                  @RequestBody @Valid dto: LeituraDTO
    ): LeituraResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id:Long){
        service.deletar(id)
    }

}