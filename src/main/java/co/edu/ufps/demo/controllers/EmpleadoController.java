package co.edu.ufps.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.demo.models.Dependencia;
import co.edu.ufps.demo.models.Empleado;
import co.edu.ufps.demo.services.EmpleadoService;
import co.edu.ufps.demo.utils.ApiResponse;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping()
	public ApiResponse<List<Empleado>> getAllEmpleados() {
		List<Empleado> empleados = empleadoService.getAllEmpleados();
	    return new ApiResponse<>("success", "Lista de empleados obtenida correctamente", empleados);	
	}
	
	@GetMapping("/{id}")
	public ApiResponse<Empleado> getEmpleado(@PathVariable("id") Integer id) {

		Empleado empleado = empleadoService.getEmpleado(id);
		
		if (empleado == null) {
	        return new ApiResponse<>("error", "Empleado no encontrado", null);
	    }
	    return new ApiResponse<>("success", "Empleado encontrado", empleado);
		
	}
	
	@PostMapping
	public Empleado postEmpleado(@RequestBody Empleado empleado) {

		return empleadoService.saveEmpleado(empleado);
		
	}
	
	@PutMapping("/{id}")
	public Empleado putEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado) {

		return empleadoService.updateEmpleado(id, empleado);
		
	}
	
	@DeleteMapping("/{id}")
	public Empleado deleteEmpleado(@PathVariable("id") Integer id) {
		
		return empleadoService.deleteEmpleado(id);
		
	}
	
	@GetMapping("/{id}/dependencias")
	public ApiResponse<List<Dependencia>> getDependenciasEmpleado(@PathVariable("id") Integer id) {

		Empleado empleado = empleadoService.getEmpleado(id);
		
		if (empleado == null) {
	        return new ApiResponse<>("error", "Empleado no encontrado", null);
	    }
	    return new ApiResponse<>("success", "Empleado encontrado", empleado.getDependencias());
		
	}
	
	
	@PostMapping("/{id}/dependencias/{dependencia}")
	public ApiResponse<Empleado> addDependenciaEmpleado(@PathVariable("id") Integer id, @PathVariable("dependencia") Integer dependencia) {
		
		Empleado empleado = empleadoService.addDependencia(id, dependencia);
		if (empleado == null) {
			return new ApiResponse<>("error", "Se ha presentado un problema al intentar agregar la dependencia", empleado);
		}
		return new ApiResponse<>("success", "Dependencia agregada al empleado", empleado);
		
	}
	
	
	@DeleteMapping("/{id}/dependencias/{dependencia}")
	public ApiResponse<Empleado> deleteDependenciaEmpleado(@PathVariable("id") Integer id, @PathVariable("dependencia") Integer dependencia) {
		
		Empleado empleado = empleadoService.removeDependencia(id, dependencia);
		if (empleado == null) {
			return new ApiResponse<>("error", "Se ha presentado un problema al intentar eliminar la dependencia", empleado);
		}
		return new ApiResponse<>("success", "Dependencia eliminada correctamente", empleado);
		
	}

}
