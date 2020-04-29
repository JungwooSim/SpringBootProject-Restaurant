package me.restaurant.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAll();

    Review save(Review review);

    List<Review> findAllByRestaurantId(Long restaurantId);
}
