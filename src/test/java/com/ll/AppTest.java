package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    @DisplayName("테스트 1")
    void t1() {
        App app = new App();
        int rs = app.plus(1, 2);

        assertEquals(3, rs);
    }
}
