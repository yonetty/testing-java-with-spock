package com.example.tjws;

public class FeeCalculator {

    private FeeTable feeTable;

    public FeeCalculator(FeeTable feeTable) {
        this.feeTable = feeTable;
    }

    int calcTotalFee(Party party) {
        return party.getPeople()
                .stream()
                .map(Person::getAge)
                .map(FeeClassification::of)
                .map(feeTable::getFeeFor)
                .mapToInt(e -> e)
                .sum();
    }
}
