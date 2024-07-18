package com.crime.crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detectives")
public class DetectiveController {
    @Autowired
    private DetectiveService detectiveService;

    @GetMapping
    public List<Detective> getAllDetectives() {
        return detectiveService.getAllDetectives();
    }

    @PostMapping
    public Detective saveDetective(@RequestBody Detective detective) {
        return detectiveService.saveDetective(detective);
    }
}
