package com.ikeasistencia.apicorreos.ApiCorreos.repository;

import com.ikeasistencia.apicorreos.ApiCorreos.Entity.Plantillas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlantillasRepositorio extends JpaRepository<Plantillas,Integer>{

    Plantillas findById(Long id);
}