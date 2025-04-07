create database ejemplo_one_to_one;
use ejemplo_one_to_one;

create table usuario (
   id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
   correo VARCHAR(100) NOT NULL UNIQUE,
   fecha_registro DATETIME NOT NULL,
   activo BOOLEAN DEFAULT TRUE
);

create table perfil (
   id_perfil BIGINT AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(100) NOT NULL,
   direccion VARCHAR(100),
   telefono VARCHAR(9) NOT NULL UNIQUE,
   fecha_nacimiento DATE NOT NULL,
   id_usuario BIGINT,
   CONSTRAINT fk_usuario_perfil FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE
)

select * from usuario;
INSERT INTO usuario (correo, fecha_registro, activo) VALUES
('pepecabanillas@gmail.com', '2025-04-06 10:30:00', TRUE),
('marialopez@hotmail.com', '2025-04-06 11:00:00', TRUE),
('carlosgarcia@yahoo.com', '2025-04-06 12:15:00', FALSE),
('anamartinez@gmail.com', '2025-04-06 13:45:00', TRUE),
('luisfernandez@outlook.com', '2025-04-06 14:00:00', TRUE);

select * from perfil;
INSERT INTO perfil (id_perfil, nombre, direccion, telefono, fecha_nacimiento, id_usuario) VALUES
(1, 'Pepe Cabanillas', 'Av. Pardo 123, Lima', '987654321', '1990-06-15', 1),
(2, 'María López', 'Jr. San Martín 456, Arequipa', '912345678', '1985-03-22', 2),
(3, 'Carlos García', 'Calle Los Olivos 789, Trujillo', '923456789', '1992-09-10', 3),
(4, 'Ana Martínez', 'Av. La Marina 1010, Lima', '954123456', '1988-12-05', 4),
(5, 'Luis Fernández', 'Calle de los Andes 500, Cusco', '933567890', '1995-01-30', 5);