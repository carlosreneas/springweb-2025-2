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
import co.edu.ufps.demo.services.DependenciaService;
import co.edu.ufps.demo.utils.ApiResponse;

@RestController
@RequestMapping("/dependencias")
public class DependenciaController {
	
	@Autowired
	DependenciaService dependenciaService;
	
	@GetMapping()
	public ApiResponse<List<Dependencia>> getAllDependencias() {
		List<Dependencia> dependencias = dependenciaService.getAllDependencias();
	    return new ApiResponse<>("success", "Lista de dependencias obtenida correctamente", dependencias);	
	}
	
	@GetMapping("/{id}")
	public ApiResponse<Dependencia> getDependencia(@PathVariable("id") Integer id) {

		Dependencia dependencia = dependenciaService.getDependencia(id);
		
		if (dependencia == null) {
	        return new ApiResponse<>("error", "Dependencia no encontrado", null);
	    }
	    return new ApiResponse<>("success", "Dependencia encontrado", dependencia);
		
	}
	
	@PostMapping
	public Dependencia postDependencia(@RequestBody Dependencia dependencia) {

		return dependenciaService.saveDependencia(dependencia);
		
	}
	
	@PutMapping("/{id}")
	public Dependencia putDependencia(@PathVariable("id") Integer id, @RequestBody Dependencia dependencia) {

		return dependenciaService.updateDependencia(id, dependencia);
		
	}
	
	@DeleteMapping("/{id}")
	public Dependencia deleteDependencia(@PathVariable("id") Integer id) {
		
		return dependenciaService.deleteDependencia(id);
		
	}
	
	
	@GetMapping("/{id}/empleados")
	public ApiResponse<List<Empleado>> getEmpleadosDependencia(@PathVariable("id") Integer id) {

		Dependencia dependencia = dependenciaService.getDependencia(id);
		
		if (dependencia == null) {
	        return new ApiResponse<>("error", "Dependencia no encontrada", null);
	    }
	    return new ApiResponse<>("success", "Dependencia encontrada", dependencia.getEmpleados());
		
	}
	
	
	@PostMapping("/{id}/empleados/{empleado}")
	public ApiResponse<Dependencia> addDependenciaEmpleado(@PathVariable("id") Integer id, @PathVariable("empleado") Integer empleado) {
		
		Dependencia dependencia = dependenciaService.addEmpleado(id, empleado);
		if (dependencia == null) {
			return new ApiResponse<>("error", "Se ha presentado un problema al intentar agregar el empleado", dependencia);
		}
		return new ApiResponse<>("success", "Empleado agregado la dependencia", dependencia);
		
	}
	
	
	@DeleteMapping("/{id}/empleados/{empleado}")
	public ApiResponse<Dependencia> deleteDependenciaEmpleado(@PathVariable("id") Integer id, @PathVariable("empleado") Integer empleado) {
		
		Dependencia dependencia = dependenciaService.removeEmpleado(id, empleado);
		if (dependencia == null) {
			return new ApiResponse<>("error", "Se ha presentado un problema al intentar eliminar el empleado", dependencia);
		}
		return new ApiResponse<>("success", "Empleado eliminado de la dependencia correctamente", dependencia);
		
	}

}
