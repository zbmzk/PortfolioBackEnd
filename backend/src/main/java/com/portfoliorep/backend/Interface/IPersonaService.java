package com.portfoliorep.backend.Interface;

import com.portfoliorep.backend.Entity.Persona;
import java.util.*;


public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
