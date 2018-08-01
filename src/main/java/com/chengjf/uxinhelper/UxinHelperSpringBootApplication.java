package com.chengjf.uxinhelper;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Slf4j
public class UxinHelperSpringBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UxinHelperSpringBootApplication.class);
    }


    public static void main(String[] args) {
        log.info("start server.");
        SpringApplication.run(UxinHelperSpringBootApplication.class, args);
        log.info("start server completed.");
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
