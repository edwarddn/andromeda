CREATE TABLE farmaceutico(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    niver DATE,
    cpf VARCHAR(11) UNIQUE,
    oferta_dia VARCHAR(200)
);
