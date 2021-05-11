package com.daniel.rotas.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

//entidade igual no banco de dados
@Entity
data class Rota (
    //chave primária
    @Id
    // O banco de dados é quem gera o valor do id
    @GeneratedValue
    val id: Int? = null,
    val nome: String? = null,
    @OneToMany(mappedBy = "rota")
    val paradas: List<Parada> = emptyList()


)