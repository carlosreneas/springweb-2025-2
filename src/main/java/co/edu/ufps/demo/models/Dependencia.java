package co.edu.ufps.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dependencia")
@Data
public class Dependencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "dependencias")
    List<Empleado> empleados;

}

