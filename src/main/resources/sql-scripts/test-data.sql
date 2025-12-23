CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    minutes INT NOT NULL,
    gender VARCHAR(50) NOT NULL,
    director VARCHAR(100) NOT NULL -- Nueva columna obligatoria
    );

TRUNCATE TABLE movies;

INSERT INTO movies (name, minutes, gender, director) VALUES
    ('Dark Knight', 152, 'ACTION', 'Christopher Nolan'),
    ('Memento', 113, 'THRILLER', 'Christopher Nolan'),
    ('Matrix', 136, 'ACTION', 'Lana Wachowski');