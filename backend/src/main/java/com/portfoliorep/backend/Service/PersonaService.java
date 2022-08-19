package com.portfoliorep.backend.Service;

import com.portfoliorep.backend.Entity.Persona;
import com.portfoliorep.backend.Interface.IPersonaService;
import com.portfoliorep.backend.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired IPersonaRepository ipersoRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> perso = ipersoRepository.findAll();
        return perso;
    }

    @Override
    public void savePersona(Persona perso) {
        ipersoRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        ipersoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = ipersoRepository.findById(id).orElse(null);
        return perso;
    }
    
}
