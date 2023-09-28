package com.ikeasistencia.apicorreos.ApiCorreos.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="templates")
public class Plantillas{



    @Id
    @Column(name="idEntity")
    private Long id;
    private String nombreTemplate;
    private String descripcion;


    public Plantillas() {

    }

    public Plantillas(Long id, String nombreTemplate){
        super();
        this.id = id;
        this.nombreTemplate = nombreTemplate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTemplate() {
        return this.nombreTemplate;
    }

    public void setNombreTemplate(String nombreTemplate) {
        this.nombreTemplate = nombreTemplate;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}