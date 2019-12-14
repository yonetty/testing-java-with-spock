package com.example.tjws

import spock.lang.Specification
import spock.lang.Unroll

class FeeClassificationSpec extends Specification {

    def "20歳は大人に分類される"() {
        given: "年齢は20歳"
        int age = 20

        when: "料金分類を取得"
        def feeClass = FeeClassification.of(age)

        then: "大人"
        feeClass == FeeClassification.Adults
    }

    @Unroll
    def "年齢に応じて正しく分類される #age歳 -> #expectedClass"() {
        when: "料金分類を取得"
        def feeClass = FeeClassification.of(age)

        then: "分類が正しい"
        feeClass == expectedClass

        where:
        age  | expectedClass
        0    | FeeClassification.Infants
        3    | FeeClassification.Infants
        4    | FeeClassification.Children
        12   | FeeClassification.Children
        13   | FeeClassification.Students
        17   | FeeClassification.Students
        18   | FeeClassification.Adults
        64   | FeeClassification.Adults
        65   | FeeClassification.SeniorCitezens
    }
}
