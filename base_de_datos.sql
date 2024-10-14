create database if not exists sistema_veterinario;

use sistema_veterinario;

create table if not exists certificaciones (
    id_certificacion int primary key auto_increment,
    nom varchar(100) not null
);

create table if not exists veterinari (
    codi_colegiat int primary key,
    nom_vet varchar(100) not null,
    adreça varchar(255) not null
);

create table if not exists mascota (
    xip bigint primary key,
    nom varchar(100) not null,
    data_nacimiento date not null,
    tiene_pedigree boolean not null
);

create table if not exists te (
    id_certificacion int,
    codi_colegiat int,
    any_realitzacion year not null,
    primary key (id_certificacion, codi_colegiat),
    foreign key (id_certificacion) references certificaciones(id_certificacion),
    foreign key (codi_colegiat) references veterinari(codi_colegiat)
);

create table if not exists visita (
    codi_colegiat int,
    xip bigint,
    preu_visita decimal(10, 2) not null,
    primary key (codi_colegiat, xip),
    foreign key (codi_colegiat) references veterinari(codi_colegiat),
    foreign key (xip) references mascota(xip)
);

create table if not exists tipus (
    id_tipus int primary key auto_increment,
    nom varchar(100) not null
);

alter table mascota
add column id_tipus int,
add foreign key (id_tipus) references tipus(id_tipus);

create table if not exists propietaria (
    dni varchar(20) primary key,
    nom varchar(100) not null,
    cognom varchar(100) not null,
    telefon varchar(15) not null
);

alter table mascota
add column dni varchar(20),
add foreign key (dni) references propietaria(dni);

create table if not exists protectora (
    nom varchar(100) primary key,
    any_fundacion year not null
);

alter table mascota
add column nom_protectora varchar(100),
add foreign key (nom_protectora) references protectora(nom);
