drop table if exists config_parameters;

CREATE TABLE config_parameters (
    token                                VARCHAR(350)     NOT NULL,
    value                              VARCHAR(350)     NOT NULL,
    update_date                        DATETIME  DEFAULT NOW(),
    CONSTRAINT pk_config_parameters PRIMARY KEY (token)
)engine = InnoDB;

