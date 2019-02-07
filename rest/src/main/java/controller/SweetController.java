package controller;

import lombok.Data;
import model.Sweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SweetService;

import java.util.List;

@RestController
@Data
public class SweetController {
    @Autowired
    SweetService sweetService;

    @GetMapping(value = "sweets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Sweet> sweets() {
        return sweetService.sweets();
    }
}
