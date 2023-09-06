package com.workshop.june8.calculation.webservice;

import com.workshop.june8.calculation.exception.EndpointException;

public interface BankingService {

    public double getInterestRate(String date) throws EndpointException;

}
