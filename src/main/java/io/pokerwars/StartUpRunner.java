package io.pokerwars;



import io.pokerwars.simultor.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class StartUpRunner implements CommandLineRunner {
    private static final Logger LOG =
            (Logger) LoggerFactory.getLogger(StartUpRunner.class);

    public static int counter;

    @Autowired
    private Main mainnn;

    @Override
    public void run(String...args) throws Exception {
        LOG.info("Increment counter");
        mainnn.main(args);
    }
}
