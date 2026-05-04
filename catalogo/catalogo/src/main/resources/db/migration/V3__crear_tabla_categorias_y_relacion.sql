CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(25) NOT NULL UNIQUE
);

-- Agregamos la columna para la relación
ALTER TABLE productos ADD COLUMN categoria_id INT;

-- Creamos el vínculo 
ALTER TABLE productos 
ADD CONSTRAINT fk_productos_categorias 
FOREIGN KEY (categoria_id) REFERENCES categorias(id);

-- Insertamos datos iniciales para probar
INSERT INTO categorias (nombre_categoria) VALUES ('Mouses'), ('Notebooks'), ('Teclados');