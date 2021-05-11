package com.daniel.rotas.repositories

import com.daniel.rotas.models.Parada
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParadaRepository: JpaRepository<Parada, Int>{
}