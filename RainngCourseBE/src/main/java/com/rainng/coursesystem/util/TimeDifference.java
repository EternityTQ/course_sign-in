package com.rainng.coursesystem.util;

import java.time.LocalDateTime;
import java.time.Duration;

public class TimeDifference {
    public static boolean isDirect(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();

        // 若输入的是未来时间，则返回true
        if (now.isBefore(dateTime))return true;

        // 输入时间比当前时间要提前
        Duration duration = Duration.between(dateTime, now);
        return duration.toMinutes() < 5;
    }
}
