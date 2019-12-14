package com.example.tjws;

import java.util.Arrays;

public enum FeeClassification {

    Infants(0, 3), Children(4, 12), Students(13,17),
    Adults(18, 64), SeniorCitezens(65, 999);

    private final int from;
    private final int to;

    FeeClassification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static FeeClassification of(int age) {
        return Arrays.stream(values()).filter(e -> e.includes(age)).findAny().get();
    }

    public boolean includes(int age) {
        return from <= age && age <= to;
    }
}
