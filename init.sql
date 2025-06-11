CREATE TABLE IF NOT EXISTS users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS resources (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations (
                              id BIGSERIAL PRIMARY KEY,
                              resource_id BIGINT NOT NULL,
                              user_id BIGINT NOT NULL,
                              start_time TIMESTAMP NOT NULL,
                              end_time TIMESTAMP NOT NULL,

                              CONSTRAINT fk_resource FOREIGN KEY (resource_id) REFERENCES resources(id),
                              CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);
