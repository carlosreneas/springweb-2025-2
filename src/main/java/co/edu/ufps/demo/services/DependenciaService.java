package co.edu.ufps.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.demo.models.Dependencia;
import co.edu.ufps.demo.models.Empleado;
import co.edu.ufps.demo.repositories.DependenciaRepository;
import co.edu.ufps.demo.repositories.EmpleadoRepository;

@Service
public class DependenciaService {
	
	@Autowired
	DependenciaRepository dependenciaRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public List<Dependencia> getAllDependencias() {
		return dependenciaRepository.findAll();
	}
	
	
	public Dependencia saveDependencia(Dependencia dependencia) {
		
		Dependencia e = dependenciaRepository.save(dependencia);
		return e;
		
	}
	
	
	public Dependencia updateDependencia(Integer id, Dependencia dependenciaParam) {
		
		Dependencia dependenciaActual = dependenciaRepository.findById(id).orElse(null);
		
		//empleadoActual.setDocumento(empleadoParam.getDocumento());
		BeanUtils.copyProperties(dependenciaParam, dependenciaActual);
		
		dependenciaRepository.save(dependenciaActual);
		return dependenciaActual;
		
	}
	
	public Dependencia getDependencia(Integer id) {
				
		return dependenciaRepository.findById(id).orElse(null);
	}
	
	public Dependencia deleteDependencia(Integer id) {
		
		Dependencia dependencia = dependenciaRepository.findById(id).orElse(null);

		dependenciaRepository.deleteById(id);
		
		return dependencia;
				
	}
	
	
	public Dependencia addEmpleado(Integer id, Integer empleadoParam) {
		
		Empleado empleado = empleadoRepository.findById(empleadoParam).orElse(null);
		
		Dependencia dependencia = dependenciaRepository.findById(id).orElse(null);
		
		Empleado empleadoBuscado = dependencia.searchEmpleado(empleado);
		
		if(empleadoBuscado!=null){
			return null;
		} else {
			empleado.addDependencia(dependencia);
			dependencia.addEmpleado(empleado);
			// TODO Auto-generated method stub
			dependenciaRepository.save(dependencia);
			
			return dependencia;
		}
	}


	public Dependencia removeEmpleado(Integer id, Integer empleadoParam) {
		
		Empleado empleado = empleadoRepository.findById(empleadoParam).orElse(null);
		
		Dependencia dependencia = dependenciaRepository.findById(id).orElse(null);
		
		Empleado empleadoBuscado = dependencia.searchEmpleado(empleado);
		
		if(empleadoBuscado!=null){
			dependencia.addEmpleado(empleado);
			// TODO Auto-generated method stub
			dependenciaRepository.save(dependencia);
			return dependencia;
		}
		return null;
	}
	
	
	

}
