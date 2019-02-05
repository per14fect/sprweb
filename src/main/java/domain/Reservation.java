package domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Reservation {
    private String court;
    private LocalDate date;
    private int hour;

    public static Reservation of(int i) {
        Reservation r = new Reservation();
        r.court = "court" + i;
        r.date = LocalDate.of(2018, 12, i % 31);
        r.hour = i % 6;
        return r;
    }
}
