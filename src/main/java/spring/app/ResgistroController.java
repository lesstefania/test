package spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTO.Response;
import entity.Persona;
import repository.PersonaRepository;
import services.PersonaService;

@RestController
@RequestMapping("/persona")
public class ResgistroController {
    
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<String> crearRegistro(@RequestBody Persona registro) {
    	Persona create = personaService.create(registro);
        
        return ResponseEntity.ok(String.format("El registro de %s, próximamente tendrás %d años.", create.getNombre(), create.getEdad() + 1));
    }

    @PutMapping
    public ResponseEntity<String> actualizarRegistro(@RequestBody Persona registro) {
    	Persona update = personaService.update(registro);
        return ResponseEntity.ok(String.format("El registro de %s con la edad de %d ha sido registrado", update.getNombre(), update.getEdad()));
    }

    @GetMapping("/{idPersona}")
    public ResponseEntity<String> obtenerRegistro(@PathVariable int id) {
        Persona registro = personaService.getPersona(id);
        return ResponseEntity.ok(String.format("El registro de %s con la edad de %d ha sido registrado", registro.getNombre(), registro.getEdad()));
           
  
    }
    
    
    @DeleteMapping
    public  ResponseEntity<String> deshabilitarRegistro(@RequestBody Persona registro) {
    	 Persona p2 = personaService.getPersona(2);
         return ResponseEntity.ok(String.format("El registro de %s con la edad de %d ha sido registrado", p2.getNombre(), p2.getEdad()));
             }
}

