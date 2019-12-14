package com.example.tjws

import spock.lang.Specification

class PersonSpec extends Specification {

    def "Personを作成できる"() {
        when:
        def person = new Person("太郎", 30)

        then:
        person.getName() == "太郎"
        person.getAge() == 30
    }

}
