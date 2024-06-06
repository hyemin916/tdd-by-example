package com.hyemin.tddbyexample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        final Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(10).isEqualTo(product.amount);
        product = five.times(3);
        assertThat(15).isEqualTo(product.amount);
    }

    @Test
    public void testEquality() {
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
    }

    private class Dollar {
        public final int amount;

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
}
