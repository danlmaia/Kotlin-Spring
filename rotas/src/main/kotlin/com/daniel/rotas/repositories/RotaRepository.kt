package com.daniel.rotas.repositories

import com.daniel.rotas.models.Rota
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RotaRepository: JpaRepository<Rota, Int> {
}