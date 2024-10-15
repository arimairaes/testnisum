
CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL,
    created DATE,
    modified DATE,
    last_login DATE,
    token VARCHAR(255)
);

ALTER TABLE users
ADD CONSTRAINT unique_email UNIQUE (email);

CREATE TABLE phones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(15) NOT NULL,
    citycode VARCHAR(5) NOT NULL,
    contrycode VARCHAR(5) NOT NULL,
    user_id UUID,
    CONSTRAINT fk_usuario FOREIGN KEY (user_id) REFERENCES users(id)
);
