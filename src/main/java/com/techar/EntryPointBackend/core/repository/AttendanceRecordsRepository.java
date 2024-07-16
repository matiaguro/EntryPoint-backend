package com.techar.EntryPointBackend.core.repository;

import com.techar.EntryPointBackend.core.models.AttendanceRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRecordsRepository extends JpaRepository<AttendanceRecords,Long> {
    @Query("SELECT ar FROM AttendanceRecords ar WHERE DATE(ar.dateIn) = CURRENT_DATE AND ar.dateOff IS NULL AND ar.user.userId = :userId")
    List<AttendanceRecords> findRecordsForToday(@Param("userId") String userId);

}
