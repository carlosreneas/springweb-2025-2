package co.edu.ufps.demo.repositories;

import co.edu.ufps.demo.models.Dependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
