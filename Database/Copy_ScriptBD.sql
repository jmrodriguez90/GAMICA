create database gamicabd;
use gamicabd;



create table if not exists `niveles`(
	`id_Nivel` int auto_increment,
	`Nombre_nivel` varchar(15),
	`Descripcion` varchar(40),
primary key (`id_Nivel`));

INSERT INTO niveles VALUES ('0', 'login','Perfil para apartado de Login');
INSERT INTO niveles VALUES ('0', 'Capacitaciones','Perfil para apartado de Capacitaciones');
INSERT INTO niveles VALUES ('0', 'Proyecto','Perfil para apartado de Proyectos');
INSERT INTO niveles VALUES ('0', 'Colaborador','Perfil para apartado de Colaborador');

create table if not exists `perfil`( /*Nivel00 Login: Administrador - invitado. Nivel01 Capacitaciones: Capacitador - Alumno. Nivel 01 Proyecto: Coordinador - Administrador - Miembro - Cartas - Correos. */
	`id_Perfil` int auto_increment,
	`id_Nivel` int not null,
	`Nombre_perfil` varchar(30),
	`Detalle` varchar(70),
foreign key (`id_Nivel`) references niveles(`id_Nivel`),
primary key (`id_Perfil`));

INSERT INTO perfil VALUES ('0', '1', 'Invitado', 'Leer');
INSERT INTO perfil VALUES ('0', '1', 'Administrador de sistema', 'Control total');
INSERT INTO perfil VALUES ('0', '4', 'CCJ', 'Joven CCJ');
INSERT INTO perfil VALUES ('0', '4', 'Populorum', 'Joven Populorum');
INSERT INTO perfil VALUES ('0', '2', 'Capacitador', 'Quien imparte capacitaciones');
INSERT INTO perfil VALUES ('0', '2', 'Alumno', 'Quien recibe capacitaciones');
INSERT INTO perfil VALUES ('0', '3', 'Coordinador', 'Quien coordina un proyecto');
INSERT INTO perfil VALUES ('0', '3', 'Administrador', 'Quien coordina la economía de un proyecto');
INSERT INTO perfil VALUES ('0', '4', 'Retirado', 'Ya no forma parte del proyecto');


create table if not exists `nivel_estudios`(
	`id_NivelEs` int auto_increment,
	`Nivel_estudios` varchar(15),
primary key (`id_NivelEs`));

INSERT INTO nivel_estudios VALUES ('0', 'Ciclo Común');
INSERT INTO nivel_estudios VALUES ('0', 'Carrera');
INSERT INTO nivel_estudios VALUES ('0', 'Universidad');


create table if not exists `situacion_familiar`(
	`Sit_familiar` int auto_increment,
	`Descripcion` varchar(30),
primary key (`Sit_familiar`));

INSERT INTO situacion_familiar VALUES ('0', 'Vive con sus papas');
INSERT INTO situacion_familiar VALUES ('0', 'Vive sólo con su mamá');
INSERT INTO situacion_familiar VALUES ('0', 'Vive sólo con su papá');
INSERT INTO situacion_familiar VALUES ('0', 'Vive con un Encargado');


create table if not exists `familia`(
	`id_Familia` int auto_increment,	
	`Sit_familiar` int not null,
	`Mama` varchar(45) not null,
	`Papa` varchar(45) not null,
	`Encargado` varchar(45) not null,
    	`Telefono_familiar` int(8),
foreign key (`Sit_familiar`) references situacion_familiar(`Sit_familiar`),
primary key (`id_Familia`));

INSERT INTO familia VALUES ('0', '1', 'María Teresa Rodríguez', 'Luis Alberto Ordóñez', '', '99999999');
INSERT INTO familia VALUES ('0', '3', '', 'José Zambrano', '', '91111111');


create table if not exists `hermanos`(
	`id_Hermano` int auto_increment,
	`id_Familia` int,
	`Nombre` varchar(45) not null,
	`Edad` int(2) not null,
	`Vivienda` int(1) not null, /*Vive en casa o no*/
foreign key (`id_Familia`) references familia(`id_Familia`),
primary key (`id_Hermano`));

INSERT INTO hermanos VALUES ('0', '1', 'Luis Fernando Ordóñez', '18', '0');
INSERT INTO hermanos VALUES ('0', '1', 'Kevin Daniel Ordóñez', '16', '0');
INSERT INTO hermanos VALUES ('0', '1', 'Norma Lizeth Ordóñez', '20', '0');
INSERT INTO hermanos VALUES ('0', '2', 'Carlos Escalante', '39', '1');
INSERT INTO hermanos VALUES ('0', '2', 'Carmen Zambrano', '37', '0');
INSERT INTO hermanos VALUES ('0', '2', 'Ariel Zambrano', '30', '0');


create table if not exists `colaborador`(
	`_id_Colaborador` int auto_increment,
	`Nombre` varchar(25) not null,
	`Apellidos` varchar(25) not null,
	`Direccion` varchar(60) not null,
	`Telefono` int(8),
	`Movil` int(8),
	`Genero` varchar(1),
	`Fec_nac` date,
	`id_Familia` int not null,
	`id_NivelEs` int not null,
	`id_Perfil` int not null,
foreign key (`id_Familia`) references familia(`id_Familia`),
foreign key (`id_NivelEs`) references nivel_estudios(`id_NivelEs`),
foreign key (`id_Perfil`) references perfil(`id_Perfil`),
primary key (`_id_Colaborador`));

INSERT INTO colaborador VALUES ('0', 'José Manuel', 'Rodríguez Estrada', 'Colonia 14 de Marzo, casa nº 6406', '22455080', '94671078', 'm', '1990/02/01', '1', '3', '4');
INSERT INTO colaborador VALUES ('0', 'Rosa Margarita', 'Zambrano Pérez', 'Colonia 14 de Marzo', '22460923', '94745728', 'f', '1981/04/22', '2', '2', '3');


create table if not exists `login`(
	`Usuario` varchar(20),
	`Contraseña`  char(32) null, /* Por el cifrado MD5*/
	`id_Perfil` int not null,
	`correo` varchar(50) not null,
	`_id_Colaborador` int not null,
foreign key (`id_Perfil`) references perfil(`id_Perfil`),
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
primary key (`Usuario`));

INSERT INTO login VALUES ('jmrodriguez90', '1234', '2', 'jmrodriguez90@correo.ugr.es', '1');
INSERT INTO login VALUES ('rmzambrano81', '1234r', '1', 'rmzambrano@correo.ugr.es', '2');


create table if not exists `bitacora`(
	`id_Bit` int auto_increment,
	`Usuario` varchar(20),
	`Acontecimiento` varchar(120) not null,
	`Fecha` datetime not null,	
foreign key (`Usuario`) references login(`Usuario`),
primary key (`id_Bit`));

INSERT INTO bitacora VALUES ('0', 'rmzambrano81', 'Modificó la tabla colaborador', '2016/06/16');

create table if not exists `asignaturas` (
	`id_Asignatura` int auto_increment,
	`Nombre` varchar(25),
primary key (`id_Asignatura`));

INSERT INTO asignaturas VALUES ('0', 'Español');
INSERT INTO asignaturas VALUES ('0', 'Matemáticas');
INSERT INTO asignaturas VALUES ('0', 'Informática');

create table if not exists `resultado`(
	`id_Resultado` int auto_increment,
    `Resultado` varchar(9), /*Si aprobó o no*/
primary key (`id_Resultado`));

INSERT INTO resultado VALUES ('0', 'Aprobado');
INSERT INTO resultado VALUES ('0', 'Reprobado');
INSERT INTO resultado VALUES ('0', 'Retirado');


create table if not exists `institucion`(
	`id_Institucion` int auto_increment,
	`Nombre` varchar(70),
	`Direccion` varchar(50),
	`Telefono` int(8),
primary key (`id_Institucion`));

INSERT INTO institucion VALUES ('0', 'Universidad Nacional Autónoma de Honduras', 'Colonia Florencia', '22222222');

create table if not exists `grado`( /*Indicará si la escolaridad asociada pertenece a Ciclo común, Carrera o Universidad*/
	`id_Grado` int auto_increment,
	`Nombre` varchar(60),
	`Descripcion` varchar(60),
	`Total_clases` int(2),
primary key (`id_Grado`));

INSERT INTO grado VALUES ('0', 'Licenciatura en Informática Administrativa', 'Carrera universitaria', '53');

create table if not exists `jornada`(
	`id_Jornada` int auto_increment,
	`Jornada` varchar(20) not null,
	`Descripcion` varchar(35) not null,
primary key (`id_Jornada`));

INSERT INTO jornada VALUES ('0', 'Matutina', 'Por la mañana');
INSERT INTO jornada VALUES ('0', 'Vespertina', 'Por la tarde');
INSERT INTO jornada VALUES ('0', 'Nocturna', 'Por la noche');

create table if not exists `escolaridad`(
	`id_Escolaridad` int auto_increment,
	`id_Institucion` int not null,
	`_id_Colaborador` int not null,
	`Fec_alta` date not null,
	`Fec_baja` date,
	`id_Grado` int not null,
	`Promedio` int(3),
	`id_Jornada` int not null,
	`id_Niveles` int,
foreign key (`id_Institucion`) references institucion(`id_Institucion`),
foreign key (`id_Grado`) references grado(`id_Grado`),
foreign key (`id_Jornada`) references jornada(`id_Jornada`),
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Niveles`) references nivel_estudios(`id_Niveles`),
primary key (`id_Escolaridad`));

INSERT INTO escolaridad VALUES ('0', '1', '1', '2008/09/01', null, '1', '75', '3', '3');
INSERT INTO escolaridad VALUES ('0', '1', '2', '2004/09/01', null, '1', '100', '2', '3');


create table if not exists `asignatura_colaborador`(
	`id_Asignatura_Colaborador` int auto_increment,
	`Fecha` Date,
	`_id_Colaborador` int,
	`id_Asignatura` int not null,
	`Calif_Parcial` int(3),
	`Calif_Recup` int(3),
	`id_Resultado` int,
	`id_Escolaridad` int,
foreign key (`id_Asignatura`) references asignaturas(`id_Asignatura`),
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Resultado`) references resultado(`id_Resultado`),
foreign key (`id_Escolaridad`) references escolaridad(`id_Escolaridad`),
primary key (`id_Asignatura_Colaborador`));

INSERT INTO asignatura_colaborador VALUES ('0', '2008/09/01', '1', '1', '60', '70', '1', '1');
INSERT INTO asignatura_colaborador VALUES ('0', '2009/02/01', '1', '2', '100', '0', '1', '1');
INSERT INTO asignatura_colaborador VALUES ('0', '2004/09/01', '2', '3', '0', '100', '1', '2');



create table if not exists `detalle_asistencia`(
	`id_Detalle_asistencia` int auto_increment,
	`Tipo_asistencia` varchar(20), /*Asistencia, Inasistencia, Excusa*/
	`Observacion` varchar(60), /*Detalle del por qué del tipo_asistencia*/
primary key (`id_Detalle_asistencia`));

INSERT INTO detalle_asistencia VALUES ('0', 'Asistencia', 'Si asistió');
INSERT INTO detalle_asistencia VALUES ('0', 'Inasistencia', 'No asistió');
INSERT INTO detalle_asistencia VALUES ('0', 'Excusa', 'No asistió con motivo justificado');
INSERT INTO detalle_asistencia VALUES ('0', 'LLegada Tarde', 'Llegó después de la hora estipulada');
INSERT INTO detalle_asistencia VALUES ('0', 'Sin salida', 'No marcó su salida');
INSERT INTO detalle_asistencia VALUES ('0', 'Excusa con deducción', 'Se excusó pero aplica sanción');


create table if not exists `asistencia_diaria`(
	`id_Asistencia_diaria` int auto_increment,
	`_id_Colaborador` int not null,
	`Fecha` date,
	`HEntrada` time,
	`HSalida` time,
	`id_Detalle_asistencia` int,
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Detalle_asistencia`) references detalle_asistencia(`id_Detalle_asistencia`),
primary key (`id_Asistencia_diaria`));

INSERT INTO asistencia_diaria VALUES ('0', '1', '2016/06/16', '7:00', '12:00', '1');


create table if not exists `capacitacion`(
	`id_Capacitacion` int auto_increment,
	`Area` varchar(25), /*Español, Matemática, Inglés*/
	`Valor_economico` int(5), /*Costo por hora clase de esa capacitacino*/
primary key (`id_Capacitacion`));

INSERT INTO capacitacion VALUES ('0', 'Español', '150');
INSERT INTO capacitacion VALUES ('0', 'Matemáticas', '150');
INSERT INTO capacitacion VALUES ('0', 'Informática', '200');
INSERT INTO capacitacion VALUES ('0', 'Inglés', '200');

create table if not exists `aula`(
	`id_Aula` int auto_increment,
	`Nombre` varchar(25),
	`Ubicacion` varchar(40),
	`Aforo` int(4), /*Límite de personas en el aula*/
primary key (`id_Aula`));

INSERT INTO aula VALUES ('0', 'Aula 1', 'CCJ3', '24');
INSERT INTO aula VALUES ('0', 'Santa Rosa', 'populorum Santa Rosa de Lima', '35');


create table if not exists `dia`(
	`id_Dia` int,
	`Dia` varchar(9),
primary key (`id_Dia`));

INSERT INTO dia VALUES ('1', 'Lunes');
INSERT INTO dia VALUES ('2', 'Martes');
INSERT INTO dia VALUES ('3', 'Miércoles');
INSERT INTO dia VALUES ('4', 'Jueves');
INSERT INTO dia VALUES ('5', 'Viernes');
INSERT INTO dia VALUES ('6', 'Sábado');
INSERT INTO dia VALUES ('7', 'Domingo');

create table if not exists `grupo_capacitacion`(
	`id_Grupo` int auto_increment,
	`Estado` int(1) not null, /*Activo - Inactivo*/
	`Nombre_grupo` varchar(5) not null, /*AEN01, BEN02, CEN03(Grupo a, b o c. Capacitación de Español. Grupo de Nuevos ccj. Número de grupo 1, 2 o 3) */
	`id_Capacitacion` int not null,
	`H_inicio` time not null,
	`H_fin` time not null,
	`id_Dia` int(7) not null,
	`id_Aula` int,
foreign key (`id_Capacitacion`) references capacitacion(`id_Capacitacion`),
foreign key (`id_Dia`) references dia(`id_Dia`),
foreign key (`id_Aula`) references aula(`id_Aula`),
primary key (`id_Grupo`));

INSERT INTO grupo_capacitacion VALUES ('0', '0', 'AEN01', '1', '7:00', '8:40', '2', '1');

create table if not exists `asistencia_cap`(
	`id_Asistencia_cap` int auto_increment,
	`id_Grupo` int not null,
	`_id_Colaborador` int not null,
	`Fecha` datetime,
	`id_Detalle_asistencia` int,
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Grupo`) references grupo_capacitacion(`id_Grupo`),
foreign key (`id_Detalle_asistencia`) references detalle_asistencia(`id_Detalle_asistencia`),
primary key (`id_Asistencia_cap`));

INSERT INTO asistencia_cap VALUES ('0', '1', '1', '2016/06/16', '1');

create table if not exists `detalle_capacitacion`(
	`id_Detalle` int auto_increment,
	`id_Grupo` int not null,
	`_id_Colaborador` int not null,
	`id_Perfil` int not null,
foreign key (`id_Grupo`) references grupo_capacitacion(`id_Grupo`),
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Perfil`) references perfil(`id_Perfil`),
primary key (`id_Detalle`));

INSERT INTO detalle_capacitacion VALUES ('0', '1', '1', '6');

create table if not exists `gamicategorias`(
	`id_GamiCat` int auto_increment,
	`Nombre_categoria` varchar(15) not null,
	`Descripcion` varchar(25) not null,
primary key (`id_GamiCat`));

INSERT INTO gamicategorias VALUES ('0', 'Monedas', 'Para ganar medallas');
INSERT INTO gamicategorias VALUES ('0', 'Medallas', 'Para ganar premios');
INSERT INTO gamicategorias VALUES ('0', 'Premios', 'Mero queso');


create table if not exists `gamiacumulacion`(
	`id_GamiA` int auto_increment,
	`_id_Colaborador` int not null,
	`id_GamiCat` int not null,
	`Cantidad` int not null,
	`Fecha` date not null,
    	`Justificacion` varchar(60) not null, /*Un comentario sobre el por qué de esta recompensa*/
    	`Autorizacion` varchar(20), /*El usuario que autorizó esta recompensa*/
foreign key (`id_GamiCat`) references gamicategorias(`id_GamiCat`),
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`Autorizacion`) references login(`Usuario`),
primary key (`id_GamiA`));

INSERT INTO gamiacumulacion VALUES ('0', '1', '1', '10', '2016/06/16', 'Creación de perfil', 'jmrodriguez90');



create table if not exists `proyecto`(
	`id_Proyecto` int auto_increment,
	`Nombre_proyecto` varchar(40) not null,
	`Descripcion` varchar(70) not null,
	`Ubicacion` varchar(70) not null,
primary key (`id_Proyecto`));

INSERT INTO proyecto VALUES ('0', 'Becas San Miguel', 'Becas para niños y jóvenes', 'Casa Populorum Santa Rosa de Lima');

create table if not exists `proyecto_colaborador`(
	`id_Proyecto` int,
	`_id_Colaborador` int not null,
	`Fec_ingreso` date not null,
	`Fec_salida` date,
	`Motivo_salida` varchar(50),
	`id_Perfil` int not null,
	`AyudaE_base` int(5) not null,
foreign key (`id_Proyecto`) references proyecto(`id_Proyecto`),
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Perfil`) references perfil(`id_Perfil`),
primary key (`id_Proyecto`, `_id_Colaborador`));

INSERT INTO proyecto_colaborador VALUES ('1', '1', '2015/03/01', '2015/03/01', '', '7', '2400');
INSERT INTO proyecto_colaborador VALUES ('1', '2', '2015/03/01', null, '', '8', '4000');

create table if not exists `retencion`( /*00: sin retención. 01-n: retenida*/
	`id_Retencion` int auto_increment,
	`Concepto` varchar(15) not null,
	`Descripcion` varchar(70) not null,
primary key (`id_Retencion`));

INSERT INTO retencion VALUES ('0', 'Sin retención', 'No Tiene retenida su ayuda');

create table if not exists `ayuda_economica`(
	`id_AyudaE` int auto_increment,
	`_id_Colaborador` int not null,
	`Fec_elaboracion` datetime not null,
	`Fec_entrega` datetime,
	`id_Retencion` int,
foreign key (`_id_Colaborador`) references colaborador(`_id_Colaborador`),
foreign key (`id_Retencion`) references retencion(`id_Retencion`),
primary key (`id_AyudaE`));

INSERT INTO ayuda_economica VALUES ('0', '1', '2016/06/16', '2016/06/16', '1');

create table if not exists `devoluciones`(
	`id_Devoluciones` int auto_increment,
	`id_AyudaE` int not null,
	`Fecha` datetime not null,
	`Cantidad` int(4) not null,
	`Concepto` varchar(70) not null,
	`Encargado` varchar(20),
foreign key (`id_AyudaE`) references ayuda_economica(`id_AyudaE`),
foreign key (`Encargado`) references login(`Usuario`),
primary key (`id_Devoluciones`));

INSERT INTO devoluciones VALUES ('0', '1', '2016/06/16', '50', 'Correción en la asistencia del día 24', 'jmrodriguez90');


create table if not exists `deduccionesvar_colaborador`(
	`id_DeduccionesVar` int auto_increment,
	`id_AyudaE` int not null,
	`Concepto` varchar(50) not null,
    	`Monto` int(4) not null,
foreign key (`id_AyudaE`) references ayuda_economica(`id_AyudaE`),
primary key (`id_DeduccionesVar`));

INSERT INTO deduccionesvar_colaborador VALUES ('0', '1', 'No asistió a los días de finca', '150');



create table if not exists `deduccioneses`( /*Inasistencias, asistencias tarde*/
	`id_DeduccionesEs` int auto_increment,
	`Concepto` varchar(20) not null,
	`Descripcion` varchar(50) not null,
    	`MontoUnitario` int(4) not null,
primary key (`id_DeduccionesEs`));

INSERT INTO deduccioneses VALUES ('0', 'Llegadas tarde', 'Anotarse después de la hora de entrada', '25');


create table if not exists `deduccioneses_colaborador`(
	`id_DeduccionesEs` int,
	`id_AyudaE` int not null,
	`Faltas` int(2) not null,
foreign key (`id_AyudaE`) references ayuda_economica(`id_AyudaE`),
primary key (`id_DeduccionesEs`, `id_AyudaE`));

INSERT INTO deduccioneses_colaborador VALUES ('1', '1', '3');


create table if not exists `tipo_beneficio`(
	`Tipo_Beneficio` int auto_increment,
	`Categoria_beneficio` Varchar(15) not null, /*Libro, transporte*/
	`Descripcion` varchar(70) not null, /*Compra de libros necesarios para su estudio*/
primary key (`Tipo_Beneficio`));

INSERT INTO tipo_beneficio VALUES ('0', 'Libro', 'Compra de libros necesarios para su estudio');


create table if not exists `beneficios`(
	`id_Beneficio` int auto_increment,
	`Tipo_Beneficio` int not null,
foreign key (`Tipo_Beneficio`) references tipo_beneficio(`Tipo_Beneficio`),
primary key (`id_Beneficio`));

INSERT INTO beneficios VALUES ('0', '1');


create table if not exists `beneficios_colaborador`(
	`id_Beneficio` int,
	`id_AyudaE` int,
	`Monto` int(4) not null,
	`Descripcion` varchar(70) not null,
foreign key (`id_Beneficio`) references beneficios(`id_Beneficio`),
foreign key (`id_AyudaE`) references ayuda_economica(`id_AyudaE`),
primary key (`id_Beneficio`, `id_AyudaE`));

INSERT INTO beneficios_colaborador VALUES ('1', '1', '1400', 'Libro de Análisis probabilistico para la clase tal');
