drop table if exists user_state;

CREATE TABLE user_state (
    id_user_state         BIGINT       AUTO_INCREMENT NOT NULL,
    description                  VARCHAR(250) NOT NULL,
    CONSTRAINT pk_user_state PRIMARY KEY (id_user_state)
)engine = InnoDB;

