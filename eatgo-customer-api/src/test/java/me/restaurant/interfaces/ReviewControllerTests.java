package me.restaurant.interfaces;

import me.restaurant.application.ReviewService;
import me.restaurant.domain.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTests {
    @Autowired
    MockMvc mvc;

    @MockBean
    ReviewService reviewService;

    @Test
    public void createWithValidAttriutes() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsInVzZXJOYW1lIjoiSm9obiJ9.0nwaeM3fpDPvRGc64pyIp-JYNnuigCN9t_5ApVhPClQ";

        given(reviewService.addReview(1L, "John", 3,  "Mat-it-da")).willReturn(
                Review.builder().id(1004L).build()
        );

        mvc.perform(
                post("/restaurants/1/reviews")
                .header("Authorization", ":Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"score\" : 3, \"description\" : \"Mat-it-da\"}")
        ).andExpect(status().isCreated())
        .andExpect(header().string("location", "/restaurants/1/reviews/1004"));

        verify(reviewService).addReview(eq(1L), eq("John"), eq(3),  eq("Mat-it-da"));
    }

    @Test
    public void createWithInValidAttriutes() throws Exception {
        mvc.perform(
                post("/restaurants/1/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        ).andExpect(status().isBadRequest());

        verify(reviewService, never()).addReview(any(), any(), any(), any()); // never()을 사용하면 호출을 하지 않음. (잘못된값이 들어왔으니 만들면 안됨)
    }
}
