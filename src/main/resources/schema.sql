CREATE TABLE IF NOT EXISTS user (
    id       INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS event (
    id               INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255) NOT NULL,
    description      VARCHAR(255) NOT NULL,
    author           INTEGER NOT NULL,
    place            VARCHAR(255) NOT NULL,
    participants     INTEGER NOT NULL,
    max_participants INTEGER NOT NULL,
    published_at     DATETIME NOT NULL,
    created_at       DATETIME NOT NULL,
    FOREIGN KEY(author) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS reservation (
    id        INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id   INTEGER NOT NULL,
    event_id  INTEGER NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY(event_id) REFERENCES event(id)
);