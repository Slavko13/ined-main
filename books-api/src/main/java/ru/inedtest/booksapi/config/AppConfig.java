package ru.inedtest.booksapi.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import ru.inedtest.base.config.Base;

@SpringBootConfiguration
@Import({Base.class, HibernateConfig.class})
public class AppConfig {
}
