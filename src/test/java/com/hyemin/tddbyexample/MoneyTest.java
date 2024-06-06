package com.hyemin.tddbyexample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        final Dollar five = new Dollar(5);
        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(3)).isEqualTo(new Dollar(15));
    }

    @Test
    public void testFranMultiplication() {
        final Fran five = new Fran(5);
        assertThat(five.times(2)).isEqualTo(new Fran(10));
        assertThat(five.times(3)).isEqualTo(new Fran(15));
    }

    @Test
    public void testEquality() {
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
    }

    private class Dollar extends Money {
        private final int amount;

        public Dollar(final int amount) {
            this.amount = amount;
        }

        public Dollar times(final int mutiplier) {
            return new Dollar(amount * mutiplier);
        }

        @Override
        public boolean equals(final Object object) {
            final Dollar dollar = (Dollar) object;
            return amount == dollar.amount;
        }
    }

    private class Fran {
        private final int amount;

        public Fran(final int amount) {
            this.amount = amount;
        }

        public Fran times(final int mutiplier) {
            return new Fran(amount * mutiplier);
        }

        @Override
        public boolean equals(final Object object) {
            final Fran fran = (Fran) object;
            return amount == fran.amount;
        }
    }

    private class Money {}
}
