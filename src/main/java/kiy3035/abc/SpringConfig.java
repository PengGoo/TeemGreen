package kiy3035.abc;

import kiy3035.abc.repository.*;
//import kiy3035.abc.repository.JdbcTemplateUserRepository;
import kiy3035.abc.service.UserService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }
    @Bean
    public UserRepository userRepository() {
// return new MemoryUserRepository();
// return new JdbcUserRepository(dataSource);
// return new JdbcTemplateUserRepository(dataSource);
        return new JpaUserRepository(em);
    }


    }

