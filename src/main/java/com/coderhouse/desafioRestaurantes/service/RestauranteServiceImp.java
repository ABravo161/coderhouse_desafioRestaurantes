package com.coderhouse.desafioRestaurantes.service;

import com.coderhouse.desafioRestaurantes.model.Restaurante;
import com.coderhouse.desafioRestaurantes.repository.RestauranteRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestauranteServiceImp implements RestauranteService {

    private final RestauranteRepository repository;
    private final ObjectMapper mapper;

    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }


    @Override
    public Restaurante crearRestaurante(Restaurante restaurante) throws JsonProcessingException {
        var restauranteString = mapper.writeValueAsString(restaurante);
        var restauranteMap = mapper.readValue(restauranteString, Map.class);
        log.info("Restaurante en formato de Mapa : {}", restauranteMap);
        return repository.save(restaurante);
    }

    @Override
    public Restaurante getRestaurante(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Restaurante actualizarRestaurante(Restaurante restaurante, Long id) {
        return null;
    }

    @Override
    public void borrarRestaurante(Long id) {

    }
}
