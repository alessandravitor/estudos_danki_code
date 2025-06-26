CREATE TABLE IF NOT EXISTS pizza (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(8,2) NOT NULL,
    disponivel BOOLEAN DEFAULT TRUE,
    sabor VARCHAR(20),
    tamanho VARCHAR(15)
);
