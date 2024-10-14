-- Crear la base de datos
CREATE DATABASE veterinaria_db;

-- Seleccionar la base de datos
USE veterinaria_db;

-- Crear la tabla CERTIFICACIONES
CREATE TABLE CERTIFICACIONES (
    id_certificacion INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

-- Crear la tabla VETERINARIO
CREATE TABLE VETERINARIO (
    codi_colegiat INT PRIMARY KEY,
    nom_vet VARCHAR(100) NOT NULL,
    adreça VARCHAR(255) NOT NULL
);

-- Crear la tabla TÉ (relación entre VETERINARIO y CERTIFICACIONES)
CREATE TABLE TÉ (
    any_realitzacion YEAR NOT NULL,
    id_certificacion INT,
    codi_colegiat INT,
    PRIMARY KEY (id_certificacion, codi_colegiat),
    FOREIGN KEY (id_certificacion) REFERENCES CERTIFICACIONES(id_certificacion),
    FOREIGN KEY (codi_colegiat) REFERENCES VETERINARIO(codi_colegiat)
);

-- Crear la tabla TIPUS
CREATE TABLE TIPUS (
    id_tipus INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

-- Crear la tabla PROPIETARIO
CREATE TABLE PROPIETARIO (
    DNI VARCHAR(20) PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    cognom VARCHAR(100) NOT NULL,
    telefon VARCHAR(15) NOT NULL
);

-- Crear la tabla PROTECTORA
CREATE TABLE PROTECTORA (
    nom VARCHAR(100) PRIMARY KEY,
    any_fundación YEAR NOT NULL
);

-- Crear la tabla MASCOTA
CREATE TABLE MASCOTA (
    xip INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    data_nacimiento DATE NOT NULL,
    tiene_pedigree BOOLEAN NOT NULL,
    id_tipus INT,
    DNI VARCHAR(20),
    protectora_nom VARCHAR(100),
    FOREIGN KEY (id_tipus) REFERENCES TIPUS(id_tipus),
    FOREIGN KEY (DNI) REFERENCES PROPIETARIO(DNI),
    FOREIGN KEY (protectora_nom) REFERENCES PROTECTORA(nom)
);

-- Crear la tabla VISITA
CREATE TABLE VISITA (
    preu_visita DECIMAL(10,2) NOT NULL,
    codi_colegiat INT,
    xip INT,
    PRIMARY KEY (codi_colegiat, xip),
    FOREIGN KEY (codi_colegiat) REFERENCES VETERINARIO(codi_colegiat),
    FOREIGN KEY (xip) REFERENCES MASCOTA(xip)
);
