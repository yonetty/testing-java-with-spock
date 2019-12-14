package com.example.tjws

import spock.lang.Specification

class FeeCalculatorSpec extends Specification {

    def "一人分の料金が計算できる"() {
        given: "太郎は大人(20歳)"
        def taro = new Person("太郎", 20)
        and: "パーティは一人"
        def party = Party.of(taro)
        and: "料金表のモック"
        def feeTable = Mock(FeeTable)
        and: "料金計算機"
        def calculator = new FeeCalculator(feeTable)

        when: "料金計算を行う"
        def amount = calculator.calcTotalFee(party)

        then: "料金表が使用される"
        1 * feeTable.getFeeFor(FeeClassification.Adults) >> 1000
        and: "金額が正しい"
        amount == 1000
    }

    def "複数分の料金が計算できる"() {
        given: "太郎は大人(20歳)"
        def taro = new Person("太郎", 20)
        and: "花子は学生(16歳)"
        def hanako = new Person("花子", 16)
        and: "一郎は学生(13歳)"
        def ichiro = new Person("一郎", 13)
        and: "二郎は幼児(2歳)"
        def jiro = new Person("二郎", 2)

        and: "パーティは4人"
        def party = Party.of(taro, hanako, ichiro, jiro)
        and: "料金表のモック"
        def feeTable = Mock(FeeTable)
        and: "料金計算機"
        def calculator = new FeeCalculator(feeTable)

        when: "料金計算を行う"
        def amount = calculator.calcTotalFee(party)

        then: "料金表が使用される"
        1 * feeTable.getFeeFor(FeeClassification.Adults) >> 2000
        2 * feeTable.getFeeFor(FeeClassification.Students) >> 1400
        1 * feeTable.getFeeFor(FeeClassification.Infants) >> 200
        and: "金額が正しい"
        amount == 5000
    }

    def "空のパーティの料金が計算できる"() {
        given: "パーティは0人"
        def party = Party.of()
        and: "料金表のモック"
        def feeTable = Mock(FeeTable)
        and: "料金計算機"
        def calculator = new FeeCalculator(feeTable)

        when: "料金計算を行う"
        def amount = calculator.calcTotalFee(party)

        then: "料金表が使用されない"
        0 * feeTable.getFeeFor(FeeClassification.Adults)
        and: "金額が正しい"
        amount == 0
    }
}
