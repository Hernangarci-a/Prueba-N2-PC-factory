CREATE TABLE marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(50) NOT NULL UNIQUE
);

-- Agregar la columna para la relación en productos
ALTER TABLE productos ADD COLUMN marca_id INT;

-- Crear la restricción de llave foránea
ALTER TABLE productos 
ADD CONSTRAINT fk_productos_marcas 
FOREIGN KEY (marca_id) REFERENCES marcas(id);

-- Insertar algunas marcas de ejemplo
INSERT INTO marcas (nombre_marca) VALUES ('ASUS'), ('Intel'), ('AMD'), ('Logitech'), ('Razer');