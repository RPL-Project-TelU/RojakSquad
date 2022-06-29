package com.example.MvcReference.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.dao.UserRepository;
import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.entity.Users;

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
    CommandLineRunner insertBuku(BukuRepository bukuRepository) {
        return args -> {
            Buku buku1 = new Buku("Pemrograman Algoritma", "Dadang", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");
            Buku buku2 = new Buku("Pemrograman Algoritma II", "Dadang", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");
            Buku buku3 = new Buku("Arsitektur Komputer", "Udin", "Sinar Mars","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ultrices dui quis nisi rhoncus aliquam. Aenean suscipit nunc sit amet tellus convallis convallis. Morbi at luctus urna.","2021-02-19");
            Buku buku4 = new Buku("Software Engineering a Practitioners Approach", "Roger S. Pressman", "McGraw-Hill","Designed for the introductory programming course or the software engineering projects course offered in departments of computer science.","2021-02-19","Software_Engineering_-_Pressman.pdf");

            bukuRepository.saveAll(List.of(buku1, buku2, buku3, buku4));
        };
    }
    @Bean
    CommandLineRunner insertUser(UserRepository userRepository) {
        return args -> {
            Users mahasiswa = new Users("bambang", "mahasiswa", "123", "mahasiswa");
            Users author = new Users("budi", "author", "123", "author");

            userRepository.saveAll(List.of(mahasiswa, author));
        };
    }

    @Bean
    public StandardServletMultipartResolver multipartResolverServlet() {
        return new StandardServletMultipartResolver();
    }
    
}
