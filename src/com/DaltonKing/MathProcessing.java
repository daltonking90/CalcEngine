package com.DaltonKing;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);
}