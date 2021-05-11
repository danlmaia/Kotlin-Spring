package com.daniel.rotas.controller

import com.daniel.rotas.models.Parada
import com.daniel.rotas.models.Rota
import com.daniel.rotas.repositories.ParadaRepository
import com.daniel.rotas.repositories.RotaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/paradas")
class ParadaController (
        private val rotaRepository: RotaRepository,
        private val paradaRepository: ParadaRepository
        ){

    @PostMapping("/{rotaId}")
    fun addStop(@PathVariable rotaId: Int, @RequestBody parada: Parada): ResponseEntity<Parada> {
        return if(rotaRepository.existsById(rotaId)){
            val novaParada = parada.copy(rota = Rota(id = rotaId))
            paradaRepository.save(novaParada)
            ResponseEntity.ok().body(novaParada)
        }else{
            ResponseEntity(HttpStatus.PRECONDITION_FAILED)
        }
    }

    @DeleteMapping("/{rotaId}/{paradaId}")
    fun removeStop(@PathVariable rotaId: Int, @PathVariable paradaId: Int){
        if (rotaRepository.existsById(rotaId)){
            paradaRepository.deleteById(paradaId)
        }

    }
}