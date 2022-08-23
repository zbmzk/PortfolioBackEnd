package com.portfoliorep.backend.Controller;

import com.portfoliorep.backend.Entity.Persona;
import com.portfoliorep.backend.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersoService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersoService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona perso){
        ipersoService.savePersona(perso);
        return "Persona creada correctamente.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersoService.deletePersona(id);
        return "Persona eliminada correctamente.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        
        Persona perso = ipersoService.findPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setImg(nuevoImg);
        
        ipersoService.savePersona(perso);
        return perso;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersoService.findPersona((long)1);
    }
    
}
