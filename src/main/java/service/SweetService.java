package service;

import jdbc.DBSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class SweetService {
    @Autowired
    DBSource dbSource;

    public void testSweet() throws Exception {
        dbSource.test();
    }

}
