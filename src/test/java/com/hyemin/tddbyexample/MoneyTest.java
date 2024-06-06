package com.hyemin.tddbyexample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        final Dollar five = Money.dollar(5);
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
        assertThat(new Fran(5)).isEqualTo(new Fran(5));
        assertThat(new Fran(5)).isNotEqualTo(new Fran(6));
        assertThat(new Fran(5)).isNotEqualTo(new Dollar(5));
    }

    public static class Dollar extends Money {

        public Dollar(final int amount) {
            super(amount);
        }

        public Money times(final int mutiplier) {
            return new Dollar(amount * mutiplier);
        }
    }

    private class Fran extends Money {
        public Fran(final int amount) {
            super(amount);
        }

        public Money times(final int mutiplier) {
            return new Fran(amount * mutiplier);
        }
    }

    private static class Money {
        protected final int amount;

        private Money(final int amount) {this.amount = amount;}

        public static Dollar dollar(final int amount) {
            return new Dollar(amount);
        }

        @Override
        public boolean equals(final Object object) {
            final Money money = (Money) object;
            return amount == money.amount && getClass().equals(money.getClass());
        }
    }
}
