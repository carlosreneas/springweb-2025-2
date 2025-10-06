package co.edu.ufps.demo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

}
