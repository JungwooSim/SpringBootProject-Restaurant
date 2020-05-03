package me.restaurant.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Reservation save(Reservation reservation);
    List<Reservation> findAllByRestaurantId(Long restaurantId);
}
