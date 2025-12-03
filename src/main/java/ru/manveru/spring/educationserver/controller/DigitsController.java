package ru.manveru.spring.educationserver.controller;

import java.util.ArrayList;
import java.util.List;
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
        return ResponseEntity.ok(digitService.calculateDigits(number));
    }
    
    @GetMapping("/matrix")
    public ResponseEntity<?> printDigitsByLines (
            @RequestParam(required = false) Integer start,
            @RequestParam(required = false) Integer end,
            @RequestParam(name = "per_line", required = false) Integer perLine){
       int startParam = start != null ? start : 1;
       int endParam = end != null ? end : 100;
       int perLineParam = perLine != null ? perLine : 10;
        try {
            // Валидация параметров
            if (startParam <= 0) {
                return ResponseEntity.badRequest()
                        .body("Начальное число должно быть положительным");
            }
            
            if (endParam <= 0) {
                return ResponseEntity.badRequest()
                        .body("Конечное число должно быть положительным");
            }
            
            if (perLineParam <= 0) {
                return ResponseEntity.badRequest()
                        .body("Количество чисел в строке должно быть положительным");
            }
            if (startParam > endParam){
                return ResponseEntity.badRequest()
                        .body("Начальное число не может быть больше конечного");
            }
            return ResponseEntity.ok(digitService.printMatrix(startParam, endParam, perLineParam));
            } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Произошла ошибка при обработке запроса: " + e.getMessage());
        }
    }
    
}
