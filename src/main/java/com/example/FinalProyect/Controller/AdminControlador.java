package com.example.FinalProyect.Controller;

import com.example.FinalProyect.Model.Usuario;
import com.example.FinalProyect.Service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/dashboard")
    public String adminDashboard(Model modelo) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        return "dashboard";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "editar-usuario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarUsuario(@PathVariable Long id, Usuario usuario) {
        usuarioServicio.actualizarUsuario(id, usuario);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/borrar/{id}")
    public String borrarUsuario(@PathVariable Long id) {
        usuarioServicio.borrarUsuario(id);
        return "redirect:/admin/dashboard";
    }
}
