package ru.manveru.spring.educationserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.manveru.spring.educationserver.model.DigitSumResponse;
import ru.manveru.spring.educationserver.service.DigitService;


@RestController
@RequestMapping("/digits")
public class DigitsController {
    private final DigitService digitService;

    @Autowired
    public DigitsController(DigitService digitService) {
        this.digitService = digitService;
    }

    @GetMapping("/sum")
    public ResponseEntity<DigitSumResponse> calculateDigitSums(@RequestParam int number) {
        DigitService.DigitCalculationResult result = digitService.calculateDigits(number);
        
        DigitSumResponse response = new DigitSumResponse(
            result.totalSum,
            result.oddSum,
            result.maxDigit
        );
        
        return ResponseEntity.ok(response);
    }
    
}
