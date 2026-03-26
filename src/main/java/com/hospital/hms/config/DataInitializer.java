package com.hospital.hms.config;

import com.hospital.hms.model.Usuario;
import com.hospital.hms.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setNome("Administrador");
                repository.save(admin);
                System.out.println("Usuário padrão criado: admin/admin123");
            }
        };
    }
}
