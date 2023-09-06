package com.workshop.june8.calculation;

import com.workshop.june8.calculation.webservice.BankingService;
import com.workshop.june8.calculation.exception.CalculationException;
import com.workshop.june8.calculation.exception.EndpointException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class InterestCalculator {

    private String now = "20200608";
    private BankingService bankingService;

    @Autowired
    public InterestCalculator( BankingService bankingService){
        this.bankingService = bankingService;
    }

    public double calculateInterest( double amount, int years) throws CalculationException {

        return calculateInterest( amount, years, now);

    }

    public double calculateInterest( double amount, int years, String date) throws CalculationException {

        double interestRate = 0;

        try {
            interestRate = bankingService.getInterestRate(date);
        } catch (EndpointException e) {
            throw new CalculationException("Calculation failed due to: " + e.getMessage());
        }

        return calculateInterest( amount, years, interestRate);

    }

    private double calculateInterest( double amount, int years, double interestRate) throws CalculationException {

        double yearlyInterestPaid ;
        double totalAmount = amount;

        for (int i = 0; i <= years; i++ ){

            yearlyInterestPaid = totalAmount * interestRate;
            totalAmount += yearlyInterestPaid;
            System.out.println(i + "   " + totalAmount);
        }

        return round( totalAmount, 2);

    }

    private double round(double value, int places) {

        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();

    }

}
