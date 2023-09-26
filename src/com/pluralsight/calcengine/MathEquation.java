package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private MathOperation opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;


    public MathEquation(MathOperation opCode) {
        this.opCode = opCode;
    }

    public MathEquation(MathOperation opCode, double leftVal, double rightVal){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
        switch (opCode) {

            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }

        numberOfCalculations++;
        sumOfResults += result;

    }

    // Method overload to set vals and execute if passing in values to execute
    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    // Method overload to set vals and execute if passing in int values to execute, then casts result back to int
    public void execute(int leftVal, int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();

        result = (int) result;
    }

    @Override // Overrides the object toString Method
    public String toString() {
        char symbol = opCode.getSymbol();
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }

//    public char symbolFromOpcode(){
//        char[] opCodes = {'a', 's', 'm', 'd'};
//        char[] symbols = {'+', '-','*','/'};
//        char symbol = ' ';
//        for(int index = 0; index < opCodes.length; index++){
//            if(opCode == opCodes[index]){
//                symbol = symbols[index];
//                break;
//            }
//        }
//        return symbol;
//    }

    public static double getAverageOfResults() {
        return sumOfResults / numberOfCalculations;
    }

    public void setLeftval(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setOpCode(MathOperation opCode) {
        this.opCode = opCode;
    }

    public MathOperation getOpCode() {
        return opCode;
    }

    public double getResult() {
        return result;
    }
}
