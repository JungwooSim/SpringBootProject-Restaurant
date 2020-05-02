package me.restaurant.utils;

import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.Is.is;


public class JwtUtilTests {

    private static final String SECRET = "12345678901234567890123456789012";
    private JwtUtil jwtUtil;

    @Before
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {

        String token = jwtUtil.createToken(1004L, "John", null);

        assertThat(token, containsString("."));
    }

    @Test
    public void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsInVzZXJOYW1lIjoiSm9obiJ9.0nwaeM3fpDPvRGc64pyIp-JYNnuigCN9t_5ApVhPClQ";
        Claims claims = jwtUtil.getClaims(token);

        assertThat(claims.get("userId", Long.class), is(1004L));
        assertThat(claims.get("userName"), is("John"));
    }
}
