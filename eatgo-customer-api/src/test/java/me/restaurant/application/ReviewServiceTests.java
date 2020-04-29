package me.restaurant.application;

import me.restaurant.domain.Review;
import me.restaurant.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReviewServiceTests {

    ReviewService reviewService;

    @Mock
    ReviewRepository reviewRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void addReview() {
        Review review = Review.builder().name("Joker").score(3).description("Mat-it-da").build();

        reviewService.addReview(1004L, review);

        verify(reviewRepository).save(any());
    }
}
