package com.techar.EntryPointBackend.core.mapper;

import com.techar.EntryPointBackend.core.models.AttendanceRecords;
import com.techar.EntryPointBackend.core.models.response.AttendanceRecordsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.Duration;
import java.time.LocalDateTime;

@Mapper
public interface AttendanceRecordsMapper {

    @Mappings({
            @Mapping(target = "totalHours", expression = "java(calculateTotalHours(attendanceRecord.getDateIn(), attendanceRecord.getDateOff()))")
    })
    AttendanceRecordsResponse attendanceRecordsToAttendanceRecordsResponse(AttendanceRecords attendanceRecord);

    default Integer calculateTotalHours(LocalDateTime dateIn, LocalDateTime dateOff) {
        return  dateOff != null ? (int) Duration.between(dateIn, dateOff).toHours() : 0;
    }
}
