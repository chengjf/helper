package com.chengjf.uxinhelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UxinHelperSpringBootApplication {


    private static final Logger log = LoggerFactory.getLogger(UxinHelperSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UxinHelperSpringBootApplication.class, args);
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
