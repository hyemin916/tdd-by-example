package com.hyemin.tddbyexample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        final Money five = Money.dollar(5);
        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    public void testFranMultiplication() {
        final Fran five = Money.fran(5);
        assertThat(five.times(2)).isEqualTo(Money.fran(10));
        assertThat(five.times(3)).isEqualTo(Money.fran(15));
    }

    @Test
    public void testEquality() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
        assertThat(Money.fran(5)).isEqualTo(Money.fran(5));
        assertThat(Money.fran(5)).isNotEqualTo(Money.fran(6));
        assertThat(Money.fran(5)).isNotEqualTo(Money.dollar(5));
    }

    public static class Dollar extends Money {

        private Dollar(final int amount) {
            super(amount);
        }

        public Money times(final int mutiplier) {
            return dollar(amount * mutiplier);
        }
    }

    private static class Fran extends Money {
        private Fran(final int amount) {
            super(amount);
        }

        public Money times(final int mutiplier) {
            return fran(amount * mutiplier);
        }
    }

    private abstract static class Money {
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

        public static Fran fran(final int amount) {
            return new Fran(amount);
        }

        public abstract Money times(final int amount);
    }
}
