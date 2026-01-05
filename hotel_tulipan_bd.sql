DROP DATABASE IF EXISTS hotel_tulipan;
CREATE DATABASE hotel_tulipan CHARACTER SET utf8mb4;
USE hotel_tulipan;

CREATE TABLE cargo (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    contacto VARCHAR(100),
    correo VARCHAR(100),
    direccion VARCHAR(255),
    estado CHAR(1),
    nombre VARCHAR(100),
    telefono VARCHAR(20)
);

CREATE TABLE servicios_adicionales (
    id_servicio_adicional INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio_venta DECIMAL(10,2)
);

CREATE TABLE habitacion (
    id_habitacion INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50),
    estado VARCHAR(20),
    precio DECIMAL(10,2)
);

CREATE TABLE empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    id_usuario INT,
    estado TINYINT(1),
    fecha_contratacion DATE,
    id_cargo INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
);

CREATE TABLE huesped (
    id_huesped INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100),
    direccion VARCHAR(255),
    estado VARCHAR(20),
    fecha_nac DATE,
    fecha_reg DATE,
    numero_documento VARCHAR(20),
    telefono VARCHAR(20)
);

CREATE TABLE reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    cantidad_huespedes INT,
    estado CHAR(1),
    fecha_inicio DATE,
    fecha_fin DATE,
    id_empleado INT,
    id_habitacion INT,
    id_huesped INT,
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_habitacion) REFERENCES habitacion(id_habitacion),
    FOREIGN KEY (id_huesped) REFERENCES huesped(id_huesped)
);

CREATE TABLE suministro (
    id_suministro INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT,
    estado TINYINT(1),
    fecha_adquisicion DATE,
    id_proveedor INT,
    id_servicio_adicional INT,
    nombre_suministro VARCHAR(100),
    precio_adquisicion DECIMAL(10,2),
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor),
    FOREIGN KEY (id_servicio_adicional) REFERENCES servicios_adicionales(id_servicio_adicional)
);

CREATE TABLE vacante (
    id_vacante INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    fecha_publicacion DATE,
    id_cargo INT,
    titulo VARCHAR(100),
    FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo)
);

CREATE TABLE postulante (
    id_postulante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100),
    id_vacante INT,
    telefono VARCHAR(20),
    FOREIGN KEY (id_vacante) REFERENCES vacante(id_vacante)
);

CREATE TABLE pago (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    fecha_pago DATE,
    id_reserva INT,
    metodo_pago VARCHAR(50),
    monto DECIMAL(10,2),
    FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
);

CREATE TABLE solicitud_de_servicios (
    id_solicitud INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    estado VARCHAR(10) NOT NULL DEFAULT 'P',
    id_reserva INT NOT NULL,
    id_servicio_adicional INT NOT NULL,

    CONSTRAINT fk_solicitud_reserva
        FOREIGN KEY (id_reserva)
        REFERENCES reserva(id_reserva),

    CONSTRAINT fk_solicitud_servicio
        FOREIGN KEY (id_servicio_adicional)
        REFERENCES servicios_adicionales(id_servicio_adicional)
);


INSERT INTO cargo (descripcion) VALUES
('Gerente General'),('Recepcionista'),('Administrador'),
('Personal de Limpieza'),('Seguridad'),('Chef Ejecutivo'),
('Contador'),('Supervisor de Turno'),('Mantenimiento'),
('Marketing'),('Recursos Humanos'),('Botones'),
('Auditor'),('Asistente Contable'),('Encargado de Turno'),
('Jefe de Cocina'),('Ayudante de Cocina'),('Mozo'),
('Bartender'),('Compras'),('Logística'),('Soporte TI'),
('Soporte Técnico'),('Control de Calidad'),('Ventas'),
('Reservas'),('Eventos'),('Relaciones Públicas'),
('Conserje'),('Portero');

-- USUARIO (30)
INSERT INTO usuario (nombre_usuario, contrasena) VALUES
('baner','123'),('user2','123'),('user3','123'),('user4','123'),('user5','123'),
('user6','123'),('user7','123'),('user8','123'),('user9','123'),('user10','123'),
('user11','123'),('user12','123'),('user13','123'),('user14','123'),('user15','123'),
('user16','123'),('user17','123'),('user18','123'),('user19','123'),('user20','123'),
('user21','123'),('user22','123'),('user23','123'),('user24','123'),('user25','123'),
('user26','123'),('user27','123'),('user28','123'),('user29','123'),('user30','123');

INSERT INTO empleado VALUES
(1,'Baner','Murga',1,1,'2021-03-15',1),
(2,'Ana','López',2,1,'2022-01-10',2),
(3,'Luis','Martínez',3,1,'2020-06-20',3),
(4,'María','Gómez',4,1,'2023-02-01',4),
(5,'José','Torres',5,1,'2019-08-12',5),
(6,'Ricardo','Paredes',6,1,'2018-11-05',6),
(7,'Claudia','Ríos',7,1,'2021-04-18',7),
(8,'Pedro','Salazar',8,1,'2022-09-30',8),
(9,'Juan','Mendoza',9,1,'2020-12-01',9),
(10,'Lucía','Vega',10,1,'2021-07-22',10),
(11,'Rosa','Campos',11,1,'2023-01-09',11),
(12,'Mario','Díaz',12,1,'2022-05-14',12),
(13,'Alberto','León',13,1,'2021-10-03',13),
(14,'Sandra','Castro',14,1,'2020-02-17',14),
(15,'Miguel','Rojas',15,1,'2022-11-11',15),
(16,'Fernando','Núñez',16,1,'2019-04-27',16),
(17,'Paola','Silva',17,1,'2021-06-06',17),
(18,'Daniel','Herrera',18,1,'2022-08-19',18),
(19,'César','Ortega',19,1,'2020-09-09',19),
(20,'Vanessa','Mejía',20,1,'2023-03-15',20),
(21,'Oscar','Quispe',21,1,'2021-12-21',21),
(22,'Renzo','Acosta',22,1,'2022-02-14',22),
(23,'Patricia','Luna',23,1,'2020-07-07',23),
(24,'Hugo','Pinto',24,1,'2021-05-05',24),
(25,'Andrea','Morales',25,1,'2023-06-01',25),
(26,'Jorge','Navarro',26,1,'2022-04-04',26),
(27,'Silvia','Ramos',27,1,'2020-01-20',27),
(28,'Iván','Cabrera',28,1,'2021-09-18',28),
(29,'Rocío','Peña',29,1,'2023-02-28',29),
(30,'Diego','Flores',30,1,'2022-10-10',30);

INSERT INTO habitacion (tipo, estado, precio) VALUES
('Simple','Disponible',120.00),
('Doble','Disponible',180.00),
('Matrimonial','Disponible',200.00),
('Suite Junior','Disponible',320.00),
('Suite','Disponible',450.00),
('Simple','Disponible',130.00),
('Doble','Disponible',190.00),
('Matrimonial','Disponible',210.00),
('Suite Junior','Disponible',330.00),
('Suite','Disponible',470.00),
('Simple','Disponible',125.00),
('Doble','Disponible',185.00),
('Matrimonial','Disponible',205.00),
('Suite Junior','Disponible',340.00),
('Suite','Disponible',480.00),
('Simple','Disponible',135.00),
('Doble','Disponible',195.00),
('Matrimonial','Disponible',215.00),
('Suite Junior','Disponible',350.00),
('Suite','Disponible',500.00),
('Simple','Disponible',140.00),
('Doble','Disponible',200.00),
('Matrimonial','Disponible',220.00),
('Suite Junior','Disponible',360.00),
('Suite','Disponible',520.00),
('Simple','Disponible',145.00),
('Doble','Disponible',205.00),
('Matrimonial','Disponible',225.00),
('Suite Junior','Disponible',370.00),
('Suite','Disponible',540.00);


INSERT INTO vacante (descripcion, fecha_publicacion, id_cargo, titulo) VALUES
('Vacante activa','2024-01-01',1,'Gerente'),
('Vacante activa','2024-01-02',2,'Recepcionista'),
('Vacante activa','2024-01-03',3,'Administrador'),
('Vacante activa','2024-01-04',4,'Limpieza'),
('Vacante activa','2024-01-05',5,'Seguridad'),
('Vacante activa','2024-01-06',6,'Cocinero'),
('Vacante activa','2024-01-07',7,'Contador'),
('Vacante activa','2024-01-08',8,'Supervisor'),
('Vacante activa','2024-01-09',9,'Mantenimiento'),
('Vacante activa','2024-01-10',10,'Marketing'),
('Vacante activa','2024-01-11',11,'RRHH'),
('Vacante activa','2024-01-12',12,'Botones'),
('Vacante activa','2024-01-13',13,'Auditor'),
('Vacante activa','2024-01-14',14,'Asistente Contable'),
('Vacante activa','2024-01-15',15,'Encargado Turno'),
('Vacante activa','2024-01-16',16,'Jefe Cocina'),
('Vacante activa','2024-01-17',17,'Ayudante Cocina'),
('Vacante activa','2024-01-18',18,'Mozo'),
('Vacante activa','2024-01-19',19,'Bartender'),
('Vacante activa','2024-01-20',20,'Compras'),
('Vacante activa','2024-01-21',21,'Logística'),
('Vacante activa','2024-01-22',22,'TI'),
('Vacante activa','2024-01-23',23,'Soporte'),
('Vacante activa','2024-01-24',24,'Calidad'),
('Vacante activa','2024-01-25',25,'Ventas'),
('Vacante activa','2024-01-26',26,'Reservas'),
('Vacante activa','2024-01-27',27,'Eventos'),
('Vacante activa','2024-01-28',28,'Relaciones Públicas'),
('Vacante activa','2024-01-29',29,'Conserje'),
('Vacante activa','2024-01-30',30,'Portero');

INSERT INTO postulante (nombre, apellido, correo, id_vacante, telefono) VALUES
('Juan','Pérez','juan.perez@gmail.com',1,'987654321'),
('María','López','maria.lopez@gmail.com',2,'987654322'),
('Carlos','Ramírez','carlos.ramirez@gmail.com',3,'987654323'),
('Ana','Torres','ana.torres@gmail.com',4,'987654324'),
('Luis','Fernández','luis.fernandez@gmail.com',5,'987654325'),
('Rosa','Castillo','rosa.castillo@gmail.com',6,'987654326'),
('Miguel','Rojas','miguel.rojas@gmail.com',7,'987654327'),
('Lucía','Morales','lucia.morales@gmail.com',8,'987654328'),
('Pedro','Vargas','pedro.vargas@gmail.com',9,'987654329'),
('Elena','García','elena.garcia@gmail.com',10,'987654330'),

('Jorge','Salinas','jorge.salinas@gmail.com',11,'987654331'),
('Paola','Huamán','paola.huaman@gmail.com',12,'987654332'),
('Ricardo','Navarro','ricardo.navarro@gmail.com',13,'987654333'),
('Diana','Mendoza','diana.mendoza@gmail.com',14,'987654334'),
('Sergio','Pineda','sergio.pineda@gmail.com',15,'987654335'),
('Natalia','Cruz','natalia.cruz@gmail.com',16,'987654336'),
('Andrés','Quispe','andres.quispe@gmail.com',17,'987654337'),
('Valeria','Reyes','valeria.reyes@gmail.com',18,'987654338'),
('Fernando','Ortega','fernando.ortega@gmail.com',19,'987654339'),
('Patricia','Campos','patricia.campos@gmail.com',20,'987654340'),

('Hugo','Medina','hugo.medina@gmail.com',21,'987654341'),
('Daniela','Ríos','daniela.rios@gmail.com',22,'987654342'),
('Marco','Flores','marco.flores@gmail.com',23,'987654343'),
('Camila','Peña','camila.pena@gmail.com',24,'987654344'),
('Óscar','Luna','oscar.luna@gmail.com',25,'987654345'),
('Brenda','Silva','brenda.silva@gmail.com',26,'987654346'),
('Iván','Chávez','ivan.chavez@gmail.com',27,'987654347'),
('Karla','Espinoza','karla.espinoza@gmail.com',28,'987654348'),
('Raúl','Gutiérrez','raul.gutierrez@gmail.com',29,'987654349'),
('Sofía','Delgado','sofia.delgado@gmail.com',30,'987654350');



INSERT INTO huesped VALUES
(1,'Luis','Fernández','lfernandez@gmail.com','Miraflores - Lima','Activo','1988-04-12','2024-01-01','45678912','987654321'),
(2,'María','Quispe','mquispe@gmail.com','San Isidro - Lima','Activo','1992-08-21','2024-01-02','43219876','987654322'),
(3,'Carlos','Rojas','crojas@gmail.com','Surco - Lima','Activo','1985-03-10','2024-01-03','40123876','987654323'),
(4,'Ana','Torres','atorres@gmail.com','Barranco - Lima','Activo','1995-11-02','2024-01-04','40987612','987654324'),
(5,'José','Vargas','jvargas@gmail.com','Callao','Activo','1980-05-19','2024-01-05','41236547','987654325'),
(6,'Lucía','Salinas','lsalinas@gmail.com','Lince - Lima','Activo','1993-09-14','2024-01-06','42345678','987654326'),
(7,'Pedro','Mendoza','pmendoza@gmail.com','La Molina','Activo','1987-02-08','2024-01-07','43456789','987654327'),
(8,'Rosa','Pacheco','rpacheco@gmail.com','Chorrillos','Activo','1991-06-23','2024-01-08','44567890','987654328'),
(9,'Miguel','Cano','mcano@gmail.com','San Miguel','Activo','1989-12-01','2024-01-09','45678901','987654329'),
(10,'Elena','García','egarcia@gmail.com','Magdalena','Activo','1994-07-17','2024-01-10','46789012','987654330'),
(11,'Raúl','López','rlopez@gmail.com','Pueblo Libre','Activo','1983-01-25','2024-01-11','47890123','987654331'),
(12,'Carmen','Navarro','cnavarro@gmail.com','Jesús María','Activo','1996-10-30','2024-01-12','48901234','987654332'),
(13,'Jorge','Silva','jsilva@gmail.com','San Borja','Activo','1984-04-18','2024-01-13','49012345','987654333'),
(14,'Patricia','Reyes','preyes@gmail.com','Breña','Activo','1990-03-09','2024-01-14','40123456','987654334'),
(15,'Daniel','Acosta','dacosta@gmail.com','Ate','Activo','1986-08-27','2024-01-15','41234567','987654335'),
(16,'Sofía','Molina','smolina@gmail.com','Comas','Activo','1998-11-11','2024-01-16','42345670','987654336'),
(17,'Andrés','Peña','apena@gmail.com','Independencia','Activo','1982-06-06','2024-01-17','43456780','987654337'),
(18,'Verónica','Luna','vluna@gmail.com','Los Olivos','Activo','1991-02-14','2024-01-18','44567891','987654338'),
(19,'Óscar','Campos','ocampos@gmail.com','Rímac','Activo','1985-09-01','2024-01-19','45678902','987654339'),
(20,'Natalia','Ríos','nrios@gmail.com','San Juan Lurigancho','Activo','1993-12-20','2024-01-20','46789013','987654340'),
(21,'Bruno','Castillo','bcastillo@gmail.com','Surquillo','Activo','1987-05-05','2024-01-21','47890124','987654341'),
(22,'Paola','Flores','pflores@gmail.com','Villa El Salvador','Activo','1995-07-28','2024-01-22','48901235','987654342'),
(23,'Héctor','Medina','hmedina@gmail.com','Villa María','Activo','1981-10-03','2024-01-23','49012346','987654343'),
(24,'Diana','Cruz','dcruz@gmail.com','Chaclacayo','Activo','1997-01-19','2024-01-24','40123457','987654344'),
(25,'Iván','Ponce','iponce@gmail.com','Carabayllo','Activo','1989-04-14','2024-01-25','41234568','987654345'),
(26,'Lorena','Aguilar','laguilar@gmail.com','Puente Piedra','Activo','1992-09-09','2024-01-26','42345671','987654346'),
(27,'Renzo','Vera','rvera@gmail.com','San Martín','Activo','1986-11-23','2024-01-27','43456781','987654347'),
(28,'Camila','Suárez','csuarez@gmail.com','Cercado Lima','Activo','1999-06-02','2024-01-28','44567892','987654348'),
(29,'Alonso','Guzmán','aguzman@gmail.com','Lurín','Activo','1983-08-15','2024-01-29','45678903','987654349'),
(30,'Valeria','Montoya','vmontoya@gmail.com','Pachacamac','Activo','1996-12-07','2024-01-30','46789014','987654350');

INSERT INTO reserva VALUES
(1,2,'P','2024-02-01','2024-02-03',1,1,1),
(2,1,'P','2024-02-02','2024-02-04',2,2,2),
(3,2,'P','2024-02-03','2024-02-05',3,3,3),
(4,1,'P','2024-02-04','2024-02-06',4,4,4),
(5,2,'P','2024-02-05','2024-02-07',5,5,5),
(6,1,'P','2024-02-06','2024-02-08',6,6,6),
(7,2,'P','2024-02-07','2024-02-09',7,7,7),
(8,1,'P','2024-02-08','2024-02-10',8,8,8),
(9,2,'P','2024-02-09','2024-02-11',9,9,9),
(10,1,'P','2024-02-10','2024-02-12',10,10,10),
(11,2,'P','2024-02-11','2024-02-13',11,11,11),
(12,1,'P','2024-02-12','2024-02-14',12,12,12),
(13,2,'P','2024-02-13','2024-02-15',13,13,13),
(14,1,'P','2024-02-14','2024-02-16',14,14,14),
(15,2,'P','2024-02-15','2024-02-17',15,15,15),
(16,1,'P','2024-02-16','2024-02-18',16,16,16),
(17,2,'P','2024-02-17','2024-02-19',17,17,17),
(18,1,'P','2024-02-18','2024-02-20',18,18,18),
(19,2,'P','2024-02-19','2024-02-21',19,19,19),
(20,1,'P','2024-02-20','2024-02-22',20,20,20),
(21,2,'P','2024-02-21','2024-02-23',21,21,21),
(22,1,'P','2024-02-22','2024-02-24',22,22,22),
(23,2,'P','2024-02-23','2024-02-25',23,23,23),
(24,1,'P','2024-02-24','2024-02-26',24,24,24),
(25,2,'P','2024-02-25','2024-02-27',25,25,25),
(26,1,'P','2024-02-26','2024-02-28',26,26,26),
(27,2,'P','2024-02-27','2024-02-29',27,27,27),
(28,1,'P','2024-02-28','2024-03-01',28,28,28),
(29,2,'P','2024-03-01','2024-03-03',29,29,29),
(30,1,'P','2024-03-02','2024-03-04',30,30,30);

INSERT INTO servicios_adicionales (nombre, precio_venta) VALUES
('Desayuno',25),('Almuerzo',40),('Cena',45),('Spa',120),('Gimnasio',30),
('Lavandería',20),('Room Service',35),('Transporte',80),('Guía Turístico',100),('Piscina',25),
('Masajes',150),('Bar',50),('Mini Bar',60),('WiFi Premium',15),('Estacionamiento',20),
('Eventos',300),('Decoración',200),('Fotografía',250),('Catering',350),('Niñera',70),
('Servicio Médico',90),('Tour Local',110),('Alquiler Bicicleta',45),('Alquiler Auto',180),
('Caja Fuerte',10),('Check-in Temprano',30),('Check-out Tardío',30),
('Despertador',5),('Traducción',75),('Limpieza Extra',40);

INSERT INTO proveedor (contacto, correo, direccion, estado, nombre, telefono) VALUES
('Juan Perez','p1@mail.com','Lima','A','Proveedor 1','900001'),
('Ana Ruiz','p2@mail.com','Lima','A','Proveedor 2','900002'),
('Luis Gomez','p3@mail.com','Lima','A','Proveedor 3','900003'),
('Maria Torres','p4@mail.com','Lima','A','Proveedor 4','900004'),
('Carlos Diaz','p5@mail.com','Lima','A','Proveedor 5','900005'),
('Elena Soto','p6@mail.com','Lima','A','Proveedor 6','900006'),
('Jose Ramos','p7@mail.com','Lima','A','Proveedor 7','900007'),
('Patricia Vega','p8@mail.com','Lima','A','Proveedor 8','900008'),
('Miguel Flores','p9@mail.com','Lima','A','Proveedor 9','900009'),
('Rosa Leon','p10@mail.com','Lima','A','Proveedor 10','900010'),
('Jorge Paredes','p11@mail.com','Lima','A','Proveedor 11','900011'),
('Lucia Campos','p12@mail.com','Lima','A','Proveedor 12','900012'),
('Renzo Castillo','p13@mail.com','Lima','A','Proveedor 13','900013'),
('Paola Mendez','p14@mail.com','Lima','A','Proveedor 14','900014'),
('Victor Salas','p15@mail.com','Lima','A','Proveedor 15','900015'),
('Daniela Rios','p16@mail.com','Lima','A','Proveedor 16','900016'),
('Hugo Peña','p17@mail.com','Lima','A','Proveedor 17','900017'),
('Carmen Silva','p18@mail.com','Lima','A','Proveedor 18','900018'),
('Oscar Molina','p19@mail.com','Lima','A','Proveedor 19','900019'),
('Silvia Fuentes','p20@mail.com','Lima','A','Proveedor 20','900020'),
('Andres Quispe','p21@mail.com','Lima','A','Proveedor 21','900021'),
('Monica Navarro','p22@mail.com','Lima','A','Proveedor 22','900022'),
('Bruno Tapia','p23@mail.com','Lima','A','Proveedor 23','900023'),
('Vanessa Luna','p24@mail.com','Lima','A','Proveedor 24','900024'),
('Raul Meza','p25@mail.com','Lima','A','Proveedor 25','900025'),
('Natalia Rojas','p26@mail.com','Lima','A','Proveedor 26','900026'),
('Ivan Acosta','p27@mail.com','Lima','A','Proveedor 27','900027'),
('Karen Muñoz','p28@mail.com','Lima','A','Proveedor 28','900028'),
('Diego Herrera','p29@mail.com','Lima','A','Proveedor 29','900029'),
('Sofia Cabrera','p30@mail.com','Lima','A','Proveedor 30','900030');

INSERT INTO suministro
(cantidad, estado, fecha_adquisicion, id_proveedor, id_servicio_adicional, nombre_suministro, precio_adquisicion) VALUES
(50,1,'2024-01-01',1,1,'Café',10),
(40,1,'2024-01-02',2,2,'Arroz',8),
(30,1,'2024-01-03',3,3,'Carne',20),
(20,1,'2024-01-04',4,4,'Aceites',15),
(25,1,'2024-01-05',5,5,'Proteínas',18),
(60,1,'2024-01-06',6,6,'Detergente',6),
(70,1,'2024-01-07',7,7,'Bandejas',12),
(80,1,'2024-01-08',8,8,'Combustible',50),
(90,1,'2024-01-09',9,9,'Folletos',5),
(55,1,'2024-01-10',10,10,'Cloro',7),
(45,1,'2024-01-11',11,11,'Aceites Spa',22),
(65,1,'2024-01-12',12,12,'Bebidas',30),
(35,1,'2024-01-13',13,13,'Snacks',18),
(75,1,'2024-01-14',14,14,'Routers',40),
(85,1,'2024-01-15',15,15,'Boletas',3),
(95,1,'2024-01-16',16,16,'Decoración',60),
(25,1,'2024-01-17',17,17,'Flores',25),
(30,1,'2024-01-18',18,18,'Cámaras',120),
(20,1,'2024-01-19',19,19,'Utensilios',45),
(15,1,'2024-01-20',20,20,'Juguetes',35),
(10,1,'2024-01-21',21,21,'Botiquín',55),
(12,1,'2024-01-22',22,22,'Mapas',10),
(18,1,'2024-01-23',23,23,'Bicicletas',150),
(22,1,'2024-01-24',24,24,'Autos',500),
(28,1,'2024-01-25',25,25,'Cajas Fuertes',200),
(32,1,'2024-01-26',26,26,'Formularios',5),
(36,1,'2024-01-27',27,27,'Relojes',8),
(40,1,'2024-01-28',28,28,'Alarmas',90),
(44,1,'2024-01-29',29,29,'Equipos Audio',160),
(48,1,'2024-01-30',30,30,'Productos Limpieza',20);

INSERT INTO solicitud_de_servicios (cantidad, estado, id_reserva, id_servicio_adicional) VALUES
(1, 'P', 1, 1),
(2, 'C', 1, 2),
(1, 'C', 2, 3),
(3, 'P', 2, 4),
(2, 'A', 3, 1),
(1, 'C', 3, 5),
(4, 'P', 4, 2),
(2, 'C', 4, 3),
(1, 'P', 5, 4),
(3, 'C', 5, 1),

(2, 'P', 6, 2),
(1, 'C', 6, 5),
(2, 'A', 7, 3),
(1, 'P', 7, 4),
(3, 'C', 8, 1),
(2, 'P', 8, 2),
(1, 'C', 9, 3),
(4, 'P', 9, 5),
(2, 'C', 10, 4),
(1, 'P', 10, 1),

(3, 'C', 1, 3),
(2, 'P', 2, 5),
(1, 'C', 3, 2),
(4, 'P', 4, 1),
(2, 'C', 5, 5),
(1, 'A', 6, 4),
(3, 'P', 7, 1),
(2, 'C', 8, 3),
(1, 'P', 9, 2),
(2, 'C', 10, 5);

