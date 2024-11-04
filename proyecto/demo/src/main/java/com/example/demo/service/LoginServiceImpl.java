package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Academico;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Polo;
import com.example.demo.repository.AcademicoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.PoloRepository;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AcademicoRepository academicoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PoloRepository poloRepository;

    @Override
    public String autenticarUsuario(String correo, String contrasena) throws Exception {
        // Buscar en académicos
        Academico academico = academicoRepository.findByCorreo_ubb(correo);
        if (academico != null && academico.getContrasena_academico().equals(contrasena)) {
            return "academico";
        }

        // Buscar en estudiantes
        Estudiante estudiante = estudianteRepository.findByCorreo_estudiante(correo);
        if (estudiante != null && estudiante.getContrasena_estudiante().equals(contrasena)) {
            return "estudiante";
        }

        // Buscar en polos
        Polo polo = poloRepository.findByCorreo_polo(correo);
        if (polo != null && polo.getContrasena_polo().equals(contrasena)) {
            return "polo";
        }

        throw new Exception("Credenciales inválidas");
    }
}
