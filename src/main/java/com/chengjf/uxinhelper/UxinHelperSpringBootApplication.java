package com.chengjf.uxinhelper;

import com.chengjf.uxinhelper.service.YoutubeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class UxinHelperSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        log.info("start server.");
        SpringApplication.run(UxinHelperSpringBootApplication.class, args);
        log.info("start server completed.");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UxinHelperSpringBootApplication.class);
    }

    @Bean
    public CommandLineRunner test(YoutubeService youtubeService) {
        return (x) -> log.info("{}", youtubeService);
    }

    //    @Bean
    //    public CommandLineRunner loadData(ArticleService service) {
    //        return (args) -> {
    //            // save a couple of customers
    //            service.addArticle(new Article(1L, "Bauer"));
    //
    //
    //            // fetch all customers
    //            log.info("Customers found with findAll():");
    //            log.info("-------------------------------");
    //            for (Article article : service.getAllArticle()) {
    //                log.info(article.toString());
    //            }
    //            log.info("");
    //        };
    //    }

}
