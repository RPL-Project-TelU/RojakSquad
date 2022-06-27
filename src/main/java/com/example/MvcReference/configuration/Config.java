package com.example.MvcReference.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.entity.Buku;

@Configuration
@Component
public class Config {


    @Bean(name = "multipartResolver")
    CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000000);
        return multipartResolver;
    }

    @Bean
    CommandLineRunner commandLineRunner(BukuRepository bukuRepository) {
        return args -> {
            Buku buku1 = new Buku("Pemrograman Algoritma", "Dadang", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");
            Buku buku2 = new Buku("Pemrograman Algoritma II", "Dadang", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");
            Buku buku3 = new Buku("Arsitektur Komputer", "Udin", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");
            Buku buku4 = new Buku("Pemrograman Dasar", "Udin", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");

            bukuRepository.saveAll(List.of(buku1, buku2, buku3, buku4));
        };
    }

    @Bean
    public StandardServletMultipartResolver multipartResolverServlet() {
        return new StandardServletMultipartResolver();
    }
}
