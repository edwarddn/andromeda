CREATE TABLE pedido(
    id UUID PRIMARY KEY,
    cliente_id UUID REFERENCES cliente(id),
    farmaceutico_id UUID REFERENCES farmaceutico(id),
    valor NUMERIC(10,2) DEFAULT 0.00,
    valor_pago NUMERIC(10,2),
    troco NUMERIC(10,2),
    data TIMESTAMP DEFAULT NOW(),
    data_pagamento TIMESTAMP,
    status VARCHAR(30)
);

CREATE TABLE pedido_produto(
    pedido_id UUID REFERENCES pedido(id),
    produto_id UUID REFERENCES produto(id),
    PRIMARY KEY (pedido_id, produto_id)
);
