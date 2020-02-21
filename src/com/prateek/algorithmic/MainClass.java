package com.prateek.algorithmic;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws Exception{

        List<Integer> arrayA = new ArrayList<>() {{
            add(3);
            add(4);
            add(21);
            add(7);
        }};

        List<Integer> arrayB = new ArrayList<>() {{
            add(21);
            add(83);
            add(1);
            add(2);
        }};

        ErrorReduction<Integer> errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, 0, 0);
        System.out.println(errorReduction.getMinValue());

        errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, 1, 0);
        System.out.println(errorReduction.getMinValue());

        errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, 0, 2);
        System.out.println(errorReduction.getMinValue());

        errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, 3, 4);
        System.out.println(errorReduction.getMinValue());

        errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, arrayA.size(), arrayA.size());
        System.out.println(errorReduction.getMinValue());

        errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, arrayA.size() + 2, arrayB.size() + 2);
        System.out.println(errorReduction.getMinValue());

        errorReduction = new ErrorReduction<Integer>(arrayA, arrayB, (int) Math.pow(arrayA.size(), 2), (int) Math.pow(arrayB.size(), 2));
        System.out.println(errorReduction.getMinValue());
    }

}
