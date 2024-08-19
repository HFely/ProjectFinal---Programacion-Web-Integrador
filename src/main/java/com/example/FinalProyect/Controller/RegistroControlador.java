package com.example.FinalProyect.Controller;

import com.example.FinalProyect.Model.Usuario;
import com.example.FinalProyect.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RegistroControlador {

    private final UsuarioServicio servicio;

    @Autowired
    public RegistroControlador(UsuarioServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        List<Usuario> usuarios = servicio.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        return "index";
    }

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }

}