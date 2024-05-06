package cz.engeto.simpleexample.controller;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
public class HelloController {

    @GetMapping("/scifi")
    public String getSciFiText() throws IOException {
        return getTextFromFile("scifi.txt");
    }

    @GetMapping("/romantic")
    public String getRomanticText() throws IOException {
        return getTextFromFile("romantic.txt");
    }

    @GetMapping("/historic")
    public String getHistoricText() throws IOException {
        return getTextFromFile("historic.txt");
    }

    private String getTextFromFile(String filename) throws IOException {
        Resource resource = new ClassPathResource(filename);
        InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
        return FileCopyUtils.copyToString(reader);
    }

    }
