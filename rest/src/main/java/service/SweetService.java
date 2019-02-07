package service;

import jdbc.DBSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.Sweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Slf4j
public class SweetService {
    @Autowired
    DBSource db;

    public List<Sweet> sweets() {
        return db.sweets();
    }
}
