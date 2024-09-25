CREATE TABLE inventory_table (
    id BIGSERIAL NOT NULL,
    sku_code VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id)
);

