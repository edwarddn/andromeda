CREATE TABLE cliente(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    niver DATE,
    cpf VARCHAR(11) UNIQUE,
    email VARCHAR(200) UNIQUE
);
