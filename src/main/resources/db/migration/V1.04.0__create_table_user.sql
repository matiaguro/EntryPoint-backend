drop table if exists user;

CREATE TABLE user (
    id_user                   BIGINT       AUTO_INCREMENT NOT NULL,
    user_id                   VARCHAR(100) NOT NULL UNIQUE,
    password                  VARCHAR(100) NOT NULL,
    name                      VARCHAR(100) NOT NULL,
    lastname                  VARCHAR(100) NOT NULL,
    id_rol                    BIGINT NOT NULL,
    id_user_state             BIGINT NOT NULL,
    id_user_titles            BIGINT,
    CONSTRAINT pk_user PRIMARY KEY (id_user),
    CONSTRAINT fk_user_rol foreign key (id_rol) references rol (id_rol),
    CONSTRAINT fk_user_state foreign key (id_user_state) references user_state (id_user_state),
    CONSTRAINT fk_user_titles foreign key (id_user_titles) references user_titles (id_user_titles)
)engine = InnoDB;

