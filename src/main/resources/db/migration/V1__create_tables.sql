create table users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

create table spaces (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    user_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

create table space_user (
    space_id INT,
    user_id INT,
    CONSTRAINT space_id FOREIGN KEY (space_id) REFERENCES spaces(id),
    CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

create table registers (
    id SERIAL PRIMARY KEY,
    description VARCHAR(200),
    amount DECIMAL(10, 2),
    type VARCHAR(100),
    register_date TIMESTAMP,
    user_id INT,
    space_id INT,
    CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT space_id FOREIGN KEY (space_id) REFERENCES spaces(id)
);