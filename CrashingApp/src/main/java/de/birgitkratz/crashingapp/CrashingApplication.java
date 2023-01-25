package de.birgitkratz.crashingapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class CrashingApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrashingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrashingApplication.class, args);
    }

    public CrashingApplication(ReadMappingsServiceUsingFile service) {
        try {
            service.readMappingFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Component
    static class ReadMappingsServiceUsingFile {
        public String readMappingFile() throws IOException {
            final var file = new DefaultResourceLoader().getResource("classpath:mappings.csv").getFile();
            final var fileContent = Files.readAllLines(Path.of(file.getPath()));
            final var fileContentAsString = String.join("\n", fileContent);
            LOGGER.info(fileContentAsString);
            return fileContentAsString;
        }
    }

}
