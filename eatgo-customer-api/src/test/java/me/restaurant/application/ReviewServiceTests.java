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
        reviewService.addReview(1004L, "Joker", 3, "Mat-it-da");

        verify(reviewRepository).save(any());
    }
}
