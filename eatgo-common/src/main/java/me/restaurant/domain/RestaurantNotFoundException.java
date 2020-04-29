package me.restaurant.domain;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long id) {
        super("Could Not find restaurant " + id);
    }
}
