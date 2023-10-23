package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Persona;
import repository.PersonaRepository;
import services.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository persona;
	
	@Override
	public Persona getPersona(int id) {
		
		return persona.getById(id);
	}

	@Override
	public Persona create(Persona p) {
		p.setActivo(false);
		p.setEdad(p.getEdad()+1);
		Persona person = this.persona.save(p);
		return person;
	}

	@Override
	public Persona update(Persona p) {
		Persona p1 = persona.getById(p.getId());
		p1.setActivo(true);
		p1.setEdad(p.getEdad()); 
		p1.setNombre(p.getNombre());
		Persona person1 = this.persona.save(p);
		return person1;
	}
	public Persona registro(Persona p) {
			p.setActivo(true);
			p.setEdad(p.getEdad()); 
			p.setNombre(p.getNombre());
			Persona person = this.persona.save(p);
			return person;
		}
		
		
	}
