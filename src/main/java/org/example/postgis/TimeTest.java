package org.example.postgis;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.OffsetDateTime;

@TableName(value = "time_test", autoResultMap = true)
public class TimeTest {

    private Long id;

    private OffsetDateTime timeZone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(OffsetDateTime timeZone) {
        this.timeZone = timeZone;
    }
}
