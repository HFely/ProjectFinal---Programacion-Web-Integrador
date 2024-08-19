package com.example.FinalProyect.Service;

import com.example.FinalProyect.Controller.dto.UsuarioRegistroDTO;
import com.example.FinalProyect.Model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();

    public Usuario obtenerUsuarioPorId(Long id);

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado);

    void borrarUsuario(Long id);
}
