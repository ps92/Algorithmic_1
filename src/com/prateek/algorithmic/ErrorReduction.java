package com.prateek.algorithmic;

import java.util.ArrayList;
import java.util.List;

public class ErrorReduction <T> {

    List<Integer> arrayA;
    List<Integer> arrayB;
    Integer k1, k2;

    private ErrorReduction () {}

    public ErrorReduction(List<T> arrayA, List<T> arrayB, Integer k1, Integer k2) throws Exception {
        if (arrayA.size() != arrayB.size()) {
            throw new Exception("This array list is not same");
        }
        this.arrayA = (List<Integer>) arrayA;
        this.arrayB = (List<Integer>) arrayB;
        this.k1 = k1;
        this.k2 = k2;
    }

    public Integer getMinValue () {
        return getMinimumDifference(this.arrayA, this.arrayB, k1, k2);
    }


    private Integer getMinimumDifference (List<Integer> arrayA, List<Integer> arrayB, Integer k1, Integer k2) {

        Double noArrayChangeDifference = calculateMinimumDifference(arrayA, arrayB);

        List<List<Integer>> arrayListA = (k1 > 0) ? manipulateArrayList(arrayA, k1) : new ArrayList<>();
        List<List<Integer>> arrayListB = (k2 > 0) ? manipulateArrayList(arrayB, k2) : new ArrayList<>();

        Double minimumDifference = noArrayChangeDifference;
        for (int i = 0; i < arrayListA.size(); i++) {
            minimumDifference = Math.min(
                    minimumDifference,
                    getMinimumDifference(arrayListA.get(i), arrayB, k1-1, k2)
            );
        }

        for (int i = 0; i < arrayListB.size(); i++) {
            minimumDifference = Math.min(
                    minimumDifference,
                    getMinimumDifference(arrayListB.get(i), arrayA, k1, k2 - 1)
            );
        }

        for (int i = 0; i < arrayListA.size() && k1 > 0; i++) {
            for (int j = 0; j < arrayB.size() && k2 > 0; j++) {
                minimumDifference = Math.min(
                        minimumDifference,
                        getMinimumDifference(arrayListA.get(i), arrayListB.get(j), k1 - 1, k2 - 1)
                );
            }
        }

        return minimumDifference.intValue();

    }

    private List<List<Integer>> manipulateArrayList (List<Integer> array, Integer movesLeft) {
        List<List<Integer>> arrayList = new ArrayList<>();
        if (movesLeft > 0) {
            for (int i = 0; i < arrayA.size(); i++) {
                arrayList.add(manipulatedArrayListElement(array, true, i));
            }
            for (int i = 0; i < arrayA.size(); i++) {
                arrayList.add(manipulatedArrayListElement(array, false, i));
            }
        }
        return arrayList;
    }

    private List<Integer> manipulatedArrayListElement(List<Integer> array, Boolean plus, Integer index) {

        List<Integer> newArrayList = new ArrayList<Integer>(array);
        Integer indexManipulation = newArrayList.get(index) + ((plus) ? 1 : -1);
        newArrayList.set(index, indexManipulation);
        return newArrayList;


    }

    private Double calculateMinimumDifference (List<Integer> arrayA, List<Integer> arrayB) {
        Double errorDifference = (double) 0L;

        for (Integer i = 0; i < arrayA.size(); i++) {
            errorDifference += Math.pow( (arrayA.get(i) - arrayB.get(i)), 2 );
        }

        return errorDifference;
    }

}
