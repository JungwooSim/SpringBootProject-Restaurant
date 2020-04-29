package me.restaurant.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegionTests {

    @Test
    public void creation() {
        Category region = Category.builder().name("서울").build();

        assertThat(region.getName(), is("서울"));
    }
}
