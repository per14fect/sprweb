package test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LambdaScopeTest {
    private static final PrintStream out = System.out;

    public static void print(List<String> list) {
    //    List<String> list = Arrays.asList(args);
//        Collections.shuffle(list);
//
//        list.stream().forEach(e -> out.println(e));
//
//        out.println("SEPARATED .... ");

        for(String s: list) {
            out.println(s);
        }


    }

    public static List<String> trim(List<String> list) {
        return list.stream().map(s -> s.trim()).collect(Collectors.toList());
    }

    public static void trimOnly(List<String> list) {
        list.forEach(s -> s = "");
    }

    public static void main(String... args) throws Exception {
        while (true) {
            log.info("just check");
            Thread.sleep(30000);
        }

    }

}
