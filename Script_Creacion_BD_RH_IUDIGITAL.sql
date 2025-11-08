-- Creacion Base de datos
create database rh_iudigital;
use rh_iudigital;

-- Creacion tablas tipo catalogo
create table tipo_documento (
	tipo_documento_ID INT auto_increment primary key,
	tipo_documento CHAR(2) not null,
	unique (tipo_documento)
);

create table estado_civil (
	estado_civil_ID INT auto_increment primary key,
	estado_civil char(15) not null,
	unique (estado_civil)
);

create table sexo (
	sexo_ID INT auto_increment primary key,
	sexo char(10) not null,
	unique (sexo)
);

create table nivel_estudio (
	nivel_estudio_ID INT auto_increment primary key,
	nivel_estudio char(17),
	unique (nivel_estudio)
);

create table rol_familiar (
	rol_familiar_ID INT auto_increment primary key,
	rol_familiar char(10),
	unique (rol_familiar)
);


-- Creacion resto de tablas

create table funcionarios (
	funcionario_ID INT auto_increment primary key,
	tipo_documento_ID INT not null,
	no_identificacion varchar(20) not null,
	nombres varchar(50) not null,
	apellidos varchar(50) not null,
	estado_civil_ID INT not null,
	sexo_ID INT not null,
	direccion varchar(200),
	telefono char(15) not null,
	fecha_nacimiento date not null,
	
	unique (no_identificacion),
	
	foreign key (tipo_documento_ID) references tipo_documento(tipo_documento_ID),
	foreign key (estado_civil_ID) references estado_civil(estado_civil_ID),
	foreign key (sexo_ID) references sexo(sexo_ID)
);

create table familiares (
	familiar_ID INT auto_increment primary key,
	nombres varchar(50) not null,
	apellidos varchar(50) not null,
	rol_familiar_ID INT not null,
	funcionario_ID INT not null,
	
	foreign key (rol_familiar_ID) references rol_familiar(rol_familiar_ID),
	foreign key (funcionario_ID) references funcionarios(funcionario_ID)
);

create table formacion_academica (
	formacion_academica_ID INT auto_increment primary key,
	universidad varchar(100) not null,
	titulo varchar(50) not null,
	nivel_estudio_ID INT not null,
	funcionario_ID INT not null,
	
	foreign key (nivel_estudio_ID) references nivel_estudio(nivel_estudio_ID),
	foreign key (funcionario_ID) references funcionarios(funcionario_ID)
);

create user 'rh_user_root'@'localhost' identified by 'rh_root123';
grant all privileges on rh_iudigital.* to 'rh_user_root'@'localhost';
flush privileges;