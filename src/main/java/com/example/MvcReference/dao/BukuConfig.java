package com.example.MvcReference.dao;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.MvcReference.entity.Buku;

@Configuration
public class BukuConfig {

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
}