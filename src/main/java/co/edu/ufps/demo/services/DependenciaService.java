package co.edu.ufps.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.demo.models.Dependencia;
import co.edu.ufps.demo.repositories.DependenciaRepository;

@Service
public class DependenciaService {
	
	@Autowired
	DependenciaRepository dependenciaRepository;
	
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
	
	

}
