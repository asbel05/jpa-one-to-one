package org.gozhu;

import org.gozhu.model.Perfil;
import org.gozhu.model.Usuario;
import org.gozhu.service.UsuarioService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

        Usuario usuario = new Usuario("pepearce@gmail.com", LocalDateTime.now(), true);
        Perfil perfil = new Perfil("Pepe Arce", "Jr. Pepe Grimes", "997654632", LocalDate.of(2005, 10, 5));

        usuario.asignarPerfil(perfil);
        usuarioService.crearUsuario(usuario);

        System.out.println("Total de usuarios en la base de datos: " + usuarioService.contarUsuarios());
        System.out.println("Total de perfiles en la base de datos: " + usuarioService.contarPerfiles());

        System.out.println("Listado de usuarios con sus perfiles:");
        usuarioService.obtenerUsuarios().forEach(u -> {
            System.out.println("  Usuario ID: " + u.getId());
            System.out.println("  Correo: " + u.getCorreo());
            System.out.println("  Fecha Registro: " + u.getFechaRegistro());
            System.out.println("  Activo: " + (u.isActivo() ? "Sí" : "No"));

            if (u.getPerfil() != null) {
                System.out.println("  Perfil ID: " + u.getPerfil().getId());
                System.out.println("  Nombre: " + u.getPerfil().getNombre());
                System.out.println("  Dirección: " + u.getPerfil().getDireccion());
                System.out.println("  Teléfono: " + u.getPerfil().getTelefono());
                System.out.println("  Fecha Nacimiento: " + u.getPerfil().getFechaNacimiento());
            } else {
                System.out.println("  Este usuario no tiene perfil asociado.");
            }
            System.out.println("---------------------------------");
        });

        usuarioService.cerrar();
    }
}