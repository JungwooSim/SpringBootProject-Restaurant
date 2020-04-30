package me.restaurant.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserTests {
    @Test
    public void creation() {
        User user = User.builder()
                .email("tester@example.com")
                .level(100L)
                .name("테스터")
                .build();

        assertThat(user.getName(), is("테스터"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deativate();
        assertThat(user.isActive(), is(false));
    }

}
