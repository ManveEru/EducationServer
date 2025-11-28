package ru.manveru.spring.educationserver.model;

public class DigitSumResponse {
    private int totalSum;
    private int oddSum;
    private int maxDigit;

    public DigitSumResponse() {
    }

    public DigitSumResponse(int totalSum, int oddSum, int maxDigit) {
        this.totalSum = totalSum;
        this.oddSum = oddSum;
        this.maxDigit = maxDigit;
    }

    // Геттеры и сеттеры
    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getOddSum() {
        return oddSum;
    }

    public void setOddSum(int oddSum) {
        this.oddSum = oddSum;
    }

    public int getMaxDigit() {
        return maxDigit;
    }

    public void setMaxDigit(int maxDigit) {
        this.maxDigit = maxDigit;
    }
}
