package com.example.demo;

import com.intuit.karate.junit5.Karate;

class KarateTestRunner {

    @Karate.Test
    Karate testAffiliate() {
        return Karate.run("classpath:features/affiliate.feature");
    }

    @Karate.Test
    Karate testAnticipation() {
        return Karate.run("classpath:features/anticipation.feature");
    }

    @Karate.Test
    Karate testAppStore() {
        return Karate.run("classpath:features/appstore.feature");
    }

    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features");
    }
}
