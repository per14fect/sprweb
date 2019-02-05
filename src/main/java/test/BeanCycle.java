package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class BeanCycle implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("DISPOSABLE BEAN DESTROY");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        log.info("INITIALIZING BEAN AFTER PROPERTIES SET");
    }

    @PostConstruct
    public void init() {
//        log.info("POST CONSTRUCT INIT");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("PRE DESTROY PREDESTROY");
    }

    public void customInit() {
//        log.info("CUSTOM INIT");
    }

    public void customDestroy() {
        log.info("CUSTOM DESTROY");
    }
}
