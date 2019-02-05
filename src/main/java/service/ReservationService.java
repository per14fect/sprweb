package service;

import domain.Pair;
import domain.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReservationService {
    private List<Pair> list = new ArrayList<>();

    {
        list.add(Pair.of("court1", Reservation.of(1)));
        list.add(Pair.of("court2", Reservation.of(2)));
        list.add(Pair.of("court1", Reservation.of(12)));
        list.add(Pair.of("court2", Reservation.of(2)));
        list.add(Pair.of("court1", Reservation.of(13)));
    }

    public List<Reservation> query(String court) {
        list.forEach(pair -> System.out.println(pair.getCourt()));


        return list.stream()
                .filter(pair -> pair.getCourt().equals(court))
                .map(Pair::getReservation)
                .collect(Collectors.toList());
    }

}
