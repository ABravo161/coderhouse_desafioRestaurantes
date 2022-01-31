package com.coderhouse.desafioRestaurantes.repository;

import com.coderhouse.desafioRestaurantes.model.Restaurante;
import org.springframework.data.repository.CrudRepository;

public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {
}
