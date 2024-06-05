package com.hyemin.tddbyexample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        final Dollar five = new Dollar(5);
        five.times(2);
        assertThat(10).isEqualTo(five.amount);
        five.times(3);
        assertThat(15).isEqualTo(five.amount);
    }

    private class Dollar {
        public int amount;

        public Dollar(final int amount) {
            this.amount = amount;
        }

        public void times(final int mutiplier) {
            amount = amount * mutiplier;
        }
    }
}
