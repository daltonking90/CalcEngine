package com.DaltonKing;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCodes;
    private double result;

    public double getLeftVal() {
        return leftVal;
    }
    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }
    public double getRightVal() {
        return rightVal;
    }
    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }
    public char getOpCodes() {
        return opCodes;
    }
    public void setOpCodes(char opCodes) {
        this.opCodes = opCodes;
    }

    public double getResult() {
        return result;
    }

    public void execute(){
        switch(opCodes) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error with opCode");
                result= 0.0d;
                break;
        }
    }
}
