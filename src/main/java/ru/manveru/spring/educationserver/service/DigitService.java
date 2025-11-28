package ru.manveru.spring.educationserver.service;

import org.springframework.stereotype.Service;

@Service
public class DigitService {
    public DigitCalculationResult calculateDigits(int number) {
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

        return new DigitCalculationResult(totalSum, oddSum, maxDigit);
    }

    public static class DigitCalculationResult {
        public final int totalSum;
        public final int oddSum;
        public final int maxDigit;

        public DigitCalculationResult(int totalSum, int oddSum, int maxDigit) {
            this.totalSum = totalSum;
            this.oddSum = oddSum;
            this.maxDigit = maxDigit;
        }
    }
}
