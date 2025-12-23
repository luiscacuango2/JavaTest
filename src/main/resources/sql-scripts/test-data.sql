CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    gender VARCHAR(50) NOT NULL
    );

INSERT INTO movies (name, minutes, gender) VALUES
    ('Dark Knight', 152, 'ACTION'),
    ('Memento', 113, 'THRILLER'),
    ('Matrix', 136, 'ACTION')