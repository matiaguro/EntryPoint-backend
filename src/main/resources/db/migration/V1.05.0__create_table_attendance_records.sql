drop table if exists attendance_records;

CREATE TABLE attendance_records (
    id_attendance_records                   BIGINT       AUTO_INCREMENT NOT NULL,
    date_off                                DATETIME,
    date_in                                 DATETIME  DEFAULT NOW(),
    id_user                                 BIGINT,
    CONSTRAINT pk_attendance_records PRIMARY KEY (id_attendance_records),
    CONSTRAINT fk_user_attendance_records foreign key (id_user) references user (id_user)
)engine = InnoDB;

