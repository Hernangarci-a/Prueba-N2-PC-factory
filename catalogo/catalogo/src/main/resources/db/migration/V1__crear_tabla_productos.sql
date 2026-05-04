CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(25) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    procesador VARCHAR(70),
    memoria_ram VARCHAR(20),
    almacenamiento VARCHAR(20)
);