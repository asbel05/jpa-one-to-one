package org.gozhu.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(nullable = false, length = 100)
    private String correo;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
    private boolean activo;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Perfil perfil;

    public Usuario(String correo, LocalDateTime fechaRegistro, boolean activo) {
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
    }

    public void asignarPerfil(Perfil perfil) {
        this.perfil = perfil;
        perfil.setUsuario(this);
    }
}
