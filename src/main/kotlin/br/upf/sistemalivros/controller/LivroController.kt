package br.upf.sistemalivros.controller

import br.upf.sistemalivros.dtos.LivroDTO
import br.upf.sistemalivros.dtos.LivroResponseDTO
import br.upf.sistemalivros.service.LivroService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page
import org.springframework.data.web.PageableDefault

@RestController
@RequestMapping("/livros")
class LivroController (val service: LivroService) {

    @GetMapping
    fun listar(
            @RequestParam(required = false) tituloLivro: String?,
            @PageableDefault(size = 10) paginacao: Pageable)
    : Page<LivroResponseDTO> {
        return service.listar(tituloLivro, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id:Long): LivroResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: LivroDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<LivroResponseDTO> {
        val autorResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/autores/${autorResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(autorResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id:Long,
                  @RequestBody @Valid dto: LivroDTO
    ): LivroResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id:Long){
        service.deletar(id)
    }

}