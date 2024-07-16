package com.techar.EntryPointBackend.core.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "attendance_records")
public class AttendanceRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attendance_records")
    private Long idAttendanceRecords;

    @Column(name = "date_off")
    private LocalDateTime dateOff;

    @Column(name = "date_in")
    private LocalDateTime dateIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public boolean isDateOff (){
        if (this.dateOff == null){
            return true;
        }
        return false;
    }

}
