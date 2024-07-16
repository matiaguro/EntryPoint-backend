drop table if exists rol;

CREATE TABLE rol (
   id_rol                    BIGINT       AUTO_INCREMENT NOT NULL,
   name_rol                  VARCHAR(100) NOT NULL,
   CONSTRAINT pk_rol PRIMARY KEY (id_rol)
)engine = InnoDB;

