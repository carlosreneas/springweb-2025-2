package co.edu.ufps.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tipo_empleado")
public class TipoEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;


 // Navegación inversa (opcional)
    //@JsonIgnore
    //@JsonManagedReference
    @OneToMany(mappedBy = "tipoEmpleado", 
    		cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados;

}
