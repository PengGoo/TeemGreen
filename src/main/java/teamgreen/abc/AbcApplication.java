package teamgreen.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // JPA Auditing 사용 가능하게 해줌, BaseTimeEntity (domain)
public class AbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbcApplication.class, args);
    }


}
