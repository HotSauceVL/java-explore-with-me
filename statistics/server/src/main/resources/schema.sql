CREATE TABLE IF NOT EXISTS stats
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    app        VARCHAR(50),
    uri        VARCHAR(50),
    ip         VARCHAR(50),
    time_stamp TIMESTAMP WITHOUT TIME ZONE
);