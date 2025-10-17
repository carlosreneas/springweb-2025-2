package co.edu.ufps.demo.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Empleado {
	
	@Id
	private Integer id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String documento;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_empleado_id", nullable = false)
	@JsonIgnoreProperties({"empleados"})
    private TipoEmpleado tipoEmpleado;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			  name = "dependencia_empleado", 
			  joinColumns = @JoinColumn(name = "empleado_id"), 
			  inverseJoinColumns = @JoinColumn(name = "dependencia_id"))
	private List<Dependencia> dependencias;

}
