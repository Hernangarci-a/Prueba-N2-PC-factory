# Prueba-N2-PC-factory
Evaluación N°2 Fullstack 1  trabajo grupo N°5, Proyecto Semestral de Arquitectura de Microservicios 

coloque esto aqui por que me daba un error al ejecutar el codico con comentarios y espacios
--Migración de base de datos y Modelado de datos

-- 1. Creamos la tabla llamada 'productos' para nuestro catálogo
CREATE TABLE productos (
    
    -- El 'id' es un número único para cada producto (Clave Primaria)
    -- AUTO_INCREMENT hace que el número crezca solo (1, 2, 3...)
    id INT AUTO_INCREMENT PRIMARY KEY,
    
    -- El nombre del computador (ej: 'Laptop Gamer XYZ')
    -- NOT NULL significa que este campo no puede quedar vacío
    nombre_producto VARCHAR(25) NOT NULL,
    
    -- La marca ej: HP, Dell etc
    marca VARCHAR(20) NOT NULL,
    
    -- El precio con decimales para el dinero en general
    precio DECIMAL(10, 2) NOT NULL,
    
    -- Características técnicas sencillas
    procesador VARCHAR(25) NOT NULL,
    memoria_ram VARCHAR(20) NOT NULL,
    almacenamiento VARCHAR(20) NOT NULL);

-- Insertamos el primer producto de prueba
INSERT INTO productos (nombre, marca, precio, procesador, memoria_ram, almacenamiento) 
VALUES ('Laptop Gamer Nitro 5', 'Acer', 899990.00, 'Intel i5', '16GB', '512GB SSD');

-- Insertamos un segundo producto de prueba
INSERT INTO productos (nombre, marca, precio, procesador, memoria_ram, almacenamiento) 
VALUES ('MacBook Air M2', 'Apple', 1299990.00, 'Chip M2', '8GB', '256GB SSD');


