drop table if exists user_titles;

CREATE TABLE user_titles (
    id_user_titles               BIGINT       AUTO_INCREMENT NOT NULL,
    description                  VARCHAR(250) NOT NULL,
    key_titles                   VARCHAR(100) NOT NULL,
    CONSTRAINT pk_user_titles PRIMARY KEY (id_user_titles)
)engine = InnoDB;

