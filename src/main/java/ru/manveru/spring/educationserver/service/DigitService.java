package ru.manveru.spring.educationserver.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.manveru.spring.educationserver.model.DigitSumResponse;

@Service
public class DigitService {
    /**
     * Calculate sum of nuber's digits and it's odd digits, max digit of a number
     * @param number 
     * @return DigitSumResponse DTO
     */
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
    
    /**
     * Print digits from START to END by DIGITS_PER_LINE
     * @param start
     * @param end
     * @param digitsPerLine
     * @return List of strings whith digits.
     */
    public List<String> printMatrix(int start, int end, int digitsPerLine){
        List<String> result = new ArrayList<>();
        int current = start;
        
        while (current <= end){
            List<String> currentLine = new ArrayList<>();
            for (int i = 0; i < digitsPerLine; i++)
                if (current <= end){
                    currentLine.add(String.valueOf(current));
                    current++;
                } else {
                    currentLine.add("0");
                }
            result.add(String.join(" ", currentLine));
        }
        return result;
    
    }
}
