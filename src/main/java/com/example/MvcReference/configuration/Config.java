package com.example.MvcReference.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import org.springframework.boot.CommandLineRunner;
import com.example.MvcReference.dao.BukuRepository;
import com.example.MvcReference.dao.UserRepository;
import com.example.MvcReference.entity.Buku;
import com.example.MvcReference.entity.Users;

@Configuration
@Component
public class Config{


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
            Buku buku4 = new Buku("Software Engineering a Practitioners Approach", "Roger S. Pressman", "McGraw-Hill Companies, Inc. 1221 Avenue of the Americas, New York, NY, 10020","For almost three decades, Roger Pressman's Software Engineering: A Practitioner's Approach has been the world's leading textbook in software engineering. The new edition represents a major restructuring and update of previous editions, solidifying the book's position as the most comprehensive guide to this important subject. The chapter structure will return to a more linear presentation of software engineering topics with a direct emphasis on the major activities that are part of a generic software process. Content will focus on widely used software engineering methods and will de-emphasize or completely eliminate discussion of secondary methods, tools and techniques. The intent is to provide a more targeted, prescriptive, and focused approach, while attempting to maintain SEPA's reputation as a comprehensive guide to software engineering. The 39 chapters of this edition are organized into five parts - Process, Modeling, Quality Management, Managing Software Projects, and Advanced Topics. The book has been revised and restructured to improve pedagogical flow and emphasize new and important software engineering processes and practices.","2021-02-19","Software_Engineering_-_Pressman.pdf");

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
