CREATE TABLE if not EXISTS prices (
    id integer NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    branch_id integer NOT NULL,
    product_id integer NOT NULL,
    priority integer NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    price decimal(20,2) NOT NULL,
    curr varchar(3) NOT NULL
);