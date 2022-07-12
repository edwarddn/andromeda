CREATE TABLE fornecedor(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    niver DATE,
    cnpj VARCHAR(14) UNIQUE
);

CREATE TABLE produto(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor NUMERIC(10,2) NOT NULL
);

CREATE TABLE fornecedor_produto(
    fornecedor_id uuid references fornecedor(id),
    produto_id uuid references produto(id),
    PRIMARY KEY (fornecedor_id, produto_id)
);


