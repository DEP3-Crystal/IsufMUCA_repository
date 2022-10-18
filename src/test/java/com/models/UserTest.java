package com.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User("user", 22, "desc");


    @Test
    void score() {
        Assertions.assertEquals(0, user.getScore());

        user.setScore(100);

        Assertions.assertEquals(100, user.getScore());
    }

    @Test
    void nickName() {

        Assertions.assertEquals("user", user.getNickName());

    }

    @Test
    void currentChances() {
        Assertions.assertEquals(6, user.getCurrentChances());

        user.lowerCurrentChances();

        Assertions.assertEquals(5, user.getCurrentChances());


    }

}