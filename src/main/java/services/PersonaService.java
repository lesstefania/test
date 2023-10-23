package services;
import java.util.List;

import org.springframework.stereotype.Service;

import DTO.Response;
import entity.Persona;


public interface PersonaService {
	Persona getPersona(int id);
	Persona create(Persona p);
	
	Persona update (Persona p);
}
