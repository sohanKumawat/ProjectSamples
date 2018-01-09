
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private MusicService musicService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Spring Boot Caffeine Caching Example Configuration");

        play("trombone");
        play("guitar");
        play("trombone");
        play("bass");
        play("trombone");
    }

    private void play(String instrument){
        log.info("Calling: " + MusicServiceIml.class.getSimpleName() + ".play(\"" + instrument + "\");");
        musicService.play(instrument);
    }
}
