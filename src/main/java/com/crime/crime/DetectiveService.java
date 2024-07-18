package com.crime.crime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetectiveService {
    @Autowired
    private DetectiveRepository detectiveRepository;

    public List<Detective> getAllDetectives() {
        return detectiveRepository.findAll();
    }

    public Detective saveDetective(Detective detective) {
        return detectiveRepository.save(detective);
    }
}
