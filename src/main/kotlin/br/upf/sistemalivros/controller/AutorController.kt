package br.upf.sistemalivros.controller

import br.upf.sistemalivros.dtos.AutorDTO
import br.upf.sistemalivros.dtos.AutorResponseDTO
import br.upf.sistemalivros.service.AutorService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

@RestController
@RequestMapping("/autores")
class AutorController(val service: AutorService) {

    @GetMapping
    fun listar(
            @RequestParam(required = false) nomeAutor: String?,
            @PageableDefault(size = 10) paginacao: Pageable)
    : Page<AutorResponseDTO>{
        return service.listar(nomeAutor, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): AutorResponseDTO{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto:AutorDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AutorResponseDTO>{
        val autorResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/autores/${autorResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(autorResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id:Long,
                  @RequestBody @Valid dto: AutorDTO
    ): AutorResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id:Long){
        service.deletar(id)
    }
}