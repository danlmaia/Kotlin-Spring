package com.daniel.rotas.controller

import com.daniel.rotas.models.Rota
import com.daniel.rotas.repositories.RotaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.xml.ws.Response

@RestController
@RequestMapping("/rotas")
class RotaController(
    private val rotaRepository: RotaRepository
) {

    @PostMapping
    fun new(@RequestBody novaRota: Rota): ResponseEntity<Rota> {
        rotaRepository.save(novaRota)
        return ResponseEntity.ok().body(novaRota)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Optional<Rota>> {
        val rota = rotaRepository.findById(id)
        return if (rota.isPresent){
            ResponseEntity.ok().body(rota)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping
    fun getAll() = ResponseEntity.ok().body(rotaRepository.findAll())

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteOne(@PathVariable id: Int){
        rotaRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody novaRota: Rota): ResponseEntity<Rota> {
        return rotaRepository.findById(id)
            .map { rota ->
                val novaVersaoDaRota = novaRota.copy(id = rota.id, paradas = rota.paradas)
                rotaRepository.save(novaVersaoDaRota)
                ResponseEntity.ok().body(novaVersaoDaRota)
            }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))

    }

}