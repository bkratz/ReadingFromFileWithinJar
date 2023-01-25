package de.birgitkratz.crashingapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrashingApplicationTests {

    @Autowired
    CrashingApplication.ReadMappingsServiceUsingFile service;

    @Test
    void contextLoads() {
    }
    @Test
    void shouldReadFromMappingsFile() throws IOException {
        final var mappingsFileContent = service.readMappingFile();
        assertThat(mappingsFileContent).isNotBlank();
    }
}
