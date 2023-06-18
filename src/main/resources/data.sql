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

CREATE TABLE search_results (
    id INT PRIMARY KEY AUTO_INCREMENT,
    outbound_departure_airport VARCHAR(3),
    outbound_arrival_airport VARCHAR(3),
    outbound_departure_date VARCHAR(25),
    outbound_arrival_date VARCHAR(25),

    inbound_departure_airport VARCHAR(3),
    inbound_arrival_airport VARCHAR(3),
    inbound_departure_date VARCHAR(25),
    inbound_arrival_date VARCHAR(25),

    carrier VARCHAR(50),
    price VARCHAR(50),

    search_id INT,

    created_date DATE,
    created_user VARCHAR(50),
    updated_date DATE,
    updated_user VARCHAR(50)
);

ALTER TABLE search_results ADD FOREIGN KEY (search_id) REFERENCES flights_search(id);
