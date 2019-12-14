package com.example.tjws

import spock.lang.Specification

class PartySpec extends Specification {

    def "1人のPartyを作成できる"() {
        given: "太郎"
        def taro = new Person("太郎", 35)

        when: "パーティを組む"
        def party = Party.of(taro)

        then: "メンバーが正しい"
        party.getNumberOfPeople() == 1
        party.getPeople() == [taro]
    }

    def "複数人のPartyを作成できる"() {
        given: "太郎、花子、一郎"
        def taro = new Person("太郎", 35)
        def hanako = new Person("花子", 33)
        def ichiro = new Person("一郎", 8)

        when: "パーティを組む"
        def party = Party.of(taro, hanako, ichiro)

        then: "メンバーが正しい"
        party.getNumberOfPeople() == 3
        party.getPeople() == [taro, hanako, ichiro]
    }
}
