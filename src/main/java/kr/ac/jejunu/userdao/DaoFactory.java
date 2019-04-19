package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao getUserDao() {
        return new UserDao(getConnection());
    }

    @Bean
    public ConnectionMaker getConnection() {
        return new JejuConnectionMaker();
    }

}
