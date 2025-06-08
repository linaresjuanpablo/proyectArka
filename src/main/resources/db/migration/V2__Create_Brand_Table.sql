
CREATE TABLE IF NOT EXISTS proyectarka.brand(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(100)
);

ALTER TABLE proyectarka.product
ADD COLUMN id_brand INTEGER,
ADD CONSTRAINT fk_product_brand
    FOREIGN key (id_brand)
    REFERENCES proyectarka.brand(id)