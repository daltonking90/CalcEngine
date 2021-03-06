package com.myapp;

import com.DaltonKing.Adder;
import com.DaltonKing.CalculateBase;
import com.DaltonKing.CalculateHelper;
import com.DaltonKing.Divider;
import com.DaltonKing.DynamicHelper;
import com.DaltonKing.InvalidStatementException;
import com.DaltonKing.MathEquation;
import com.DaltonKing.MathProcessing;
import com.DaltonKing.Multiplier;
import com.DaltonKing.PowerOf;
import com.DaltonKing.Subtracter;

public class Main {

    public static void main(String[] args) {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation: equations) {
            equation.execute();
            System.out.print("Result= ");
            System.out.println(equation.getResult());
        }
        System.out.println("*******Overloading*******");

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("Result= ");
        System.out.println(equationOverload.getResult());

        System.out.println("*******Using inheritance******");

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators){
            calculator.calculate();
            System.out.print("Result = ");
            System.out.println(calculator.getResult());
        }

        System.out.println("******using CalculateHelper******");
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };
        CalculateHelper helper = new CalculateHelper();
        for(String statement:statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch(InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("Original exception: " + e.getCause().getMessage());
                }
            }
        }

        System.out.println("******Using interface******");

        String[] statements2 = {
                "add 27.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper2 = new DynamicHelper(new MathProcessing[]{
                new Adder(),
                new PowerOf()
        });

        for(String statement2:statements2){
            String output = helper2.process(statement2);
            System.out.println(output);
        }
    }

}
