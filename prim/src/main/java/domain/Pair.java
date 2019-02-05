package domain;

import lombok.Data;

@Data
public class Pair {
    private String court;
    private Reservation reservation;

    private Pair() {}

    public static Pair of(String court, Reservation reservation) {
        Pair pair = new Pair();
        pair.court = court;
        pair.reservation = reservation;
        return pair;
    }
}
