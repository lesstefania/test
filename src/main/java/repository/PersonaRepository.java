package repository;

	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Persona;
@Repository
	public interface PersonaRepository extends JpaRepository<Persona, Long> {
		
		Persona getById(int id);

	    //
	}

