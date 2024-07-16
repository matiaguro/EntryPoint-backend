package com.techar.EntryPointBackend.core.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
public class DateUtils {
    public static LocalDateTime getDate() {
        ZoneId zoneId = ZoneId.of("America/Argentina/Buenos_Aires");

        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);

        return zonedDateTime.toLocalDateTime();
    }
}


