package log4j;

import org.apache.logging.log4j.LogManager;

/**
 * Hello world!
 */
public class App {

    private static final org.apache.logging.log4j.Logger log =LogManager.getLogger(App.class);


    public static void process(){
        System.out.println("Processing...");
        log.info("info process");
        log.error("error process");
        log.warn("warn process");
        log.debug("debug process");
        log.fatal("fatal process");
        log.trace("trace process");
        System.out.println("Done!");
    }

    public static void main(String[] args) {
        process();
    }
}
