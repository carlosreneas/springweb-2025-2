package co.edu.ufps.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.demo.models.Empleado;
import co.edu.ufps.demo.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping()
	public List<Empleado> getAllEmpleados() {
		
		return empleadoService.getAllEmpleados();
		
	}
	
	@GetMapping("/{id}")
	public Empleado getEmpleado(@PathVariable Integer id) {
		
		return empleadoService.getEmpleado(id);
		
	}

}
