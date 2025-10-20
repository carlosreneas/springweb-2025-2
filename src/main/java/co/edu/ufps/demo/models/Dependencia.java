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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependencia dependencia = (Dependencia) o;
        return id.equals(dependencia.id);  // Compara por id
    }

    @Override
    public int hashCode() {
        return id.hashCode();  // Usamos el id para el hashCode
    }
    
    public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}
	
	public void removeEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}
	
	public Empleado searchEmpleado(Empleado empleadoParam) {
		for (Empleado empleado : this.empleados) {
            if (empleado.getId().equals(empleadoParam.getId())) {
                return empleado;
            }
        }
		return null;
	}

}

