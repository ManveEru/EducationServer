package ru.manveru.spring.educationserver.service;

import org.springframework.stereotype.Service;
import ru.manveru.spring.educationserver.model.DigitSumResponse;

@Service
public class DigitService {
    public DigitSumResponse calculateDigits(int number) {
        // Работаем с абсолютным значением чтобы избежать проблем с отрицательными числами
        String numberStr = String.valueOf(Math.abs(number));
        int totalSum = 0;
        int oddSum = 0;
        int maxDigit = 0;

        for (char digitChar : numberStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            
            totalSum += digit;
            
            if (digit % 2 != 0) {
                oddSum += digit;
            }
            
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }

        return new DigitSumResponse(totalSum, oddSum, maxDigit);
    }
}
