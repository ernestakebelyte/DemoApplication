package com.example.demoappback;

import com.example.demoappback.services.DataGenerationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class DemoAppBackApplication {
    
    private final DataGenerationService dataGenerationService;

    public DemoAppBackApplication(DataGenerationService dataGenerationService) {
        this.dataGenerationService = dataGenerationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoAppBackApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        dataGenerationService.initData();
    }
}
