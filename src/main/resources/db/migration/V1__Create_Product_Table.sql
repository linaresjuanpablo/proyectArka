CREATE SCHEMA IF NOT EXISTS proyectarka;

CREATE TABLE IF NOT EXISTS proyectarka.product (
  id SERIAL PRIMARY KEY,
  uuid CHAR(36),
  name VARCHAR(45),
  description VARCHAR(45),
  price DOUBLE PRECISION,
  sku VARCHAR(45),
  quantity VARCHAR(45)
);
