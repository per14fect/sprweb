package controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.SweetService;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Locale;

@Slf4j
@Controller
@Data
public class WelcomeController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    SweetService sweetService;

    @RequestMapping(method = RequestMethod.GET, value = "welcome")
    public String welcome(Model model, HttpServletRequest req) throws Exception {

        model.addAttribute("date", LocalDate.now());

        sweetService.testSweet();


        req.login("one", "two");



        log.info("session timeout = {}", servletContext.getSessionTimeout());
        log.info("session getMaxInactiveInterval = {}", req.getSession().getMaxInactiveInterval());
        log.info("session id = {}", req.getSession().getId());
        return "static/start.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout(HttpServletRequest req) throws Exception {
        req.logout();
        return "static/logout.html";
    }

    @PostConstruct
    public void init() {
        log.info("class = {}", servletContext.getClass());
        log.info("contextPath = {}", servletContext.getContextPath());
        servletContext.getResourcePaths("/").forEach(s -> log.info("resource = {}", s));
    }
}
