package de.birgitkratz.successapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@SpringBootApplication
public class SuccessApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SuccessApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SuccessApplication.class, args);
    }

    public SuccessApplication(ReadMappingsServiceUsingInputStream service) {
        try {
            service.readMappingFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Component
    static class ReadMappingsServiceUsingInputStream {
        public String readMappingFile() throws IOException {
            try (var inputStream = new DefaultResourceLoader().getResource("classpath:mappings.csv").getInputStream();
                 var bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                var fileContentAsString = bufferedReader.lines().collect(Collectors.joining("\n"));
                LOGGER.info(fileContentAsString);
                return fileContentAsString;
            }
        }
    }

}
