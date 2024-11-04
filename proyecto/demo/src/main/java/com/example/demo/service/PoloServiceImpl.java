package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Polo;
import com.example.demo.repository.PoloRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PoloServiceImpl implements PoloService {

    @Autowired 
    PoloRepository repPolo;

    @Override
    public List<Polo> buscarPolo() {
        return repPolo.findAll();
    }
    
    @Override
    public Polo registrarPolo(Polo polo) {
        // Aquí podrías agregar validaciones, como verificar si el correo ya existe
        return repPolo.save(polo);
    }

    @Override
    public Polo login(String correo, String contrasena) {
        Optional<Polo> polo = repPolo.findByCorreo_poloAndContrasena_polo(correo, contrasena);
        return polo.orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));
    }
}
