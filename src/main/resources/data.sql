CREATE TABLE test (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(255)
);

INSERT INTO test(name, description) values ('Laura', 'Spava');

CREATE TABLE flights_search (
    id INT PRIMARY KEY AUTO_INCREMENT,
    origin_location_code VARCHAR(3),
    destination_location_code VARCHAR(3),
    departure_date DATE,
    return_date DATE,
    adults INT,

    created_date DATE,
    created_user VARCHAR(50),
    updated_date DATE,
    updated_user VARCHAR(50)
);
