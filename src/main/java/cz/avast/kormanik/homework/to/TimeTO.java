package cz.avast.kormanik.homework.to;

import java.time.LocalDateTime;

public class TimeTO {

    private LocalDateTime now;

    public TimeTO(LocalDateTime now) {
        this.now = now;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

}
