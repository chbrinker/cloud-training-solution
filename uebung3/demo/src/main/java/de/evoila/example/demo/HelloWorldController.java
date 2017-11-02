package de.evoila.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    public CloudConfigurationProperties properties;

    public HelloWorldController(CloudConfigurationProperties properties) {
        log.info("Started with property set to: " + properties.getMyprop() + ".");

        this.properties = properties;
    }

    @GetMapping("/home")
    public ResponseEntity<?> getMyProperty() {
        try {
            return new ResponseEntity<>(properties.getMyprop(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return new ResponseEntity<>(
                    "Internal error occurred. Please contact your administrator.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
