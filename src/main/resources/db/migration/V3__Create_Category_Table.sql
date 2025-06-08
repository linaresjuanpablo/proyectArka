CREATE TABLE IF NOT EXISTS proyectarka.category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL

);

ALTER TABLE proyectarka.product
ADD COLUMN id_category INTEGER,
ADD CONSTRAINT fk_product_category
    FOREIGN key (id_category)
    REFERENCES proyectarka.category(id)