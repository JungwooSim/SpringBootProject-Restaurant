package domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository() {
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(Long id) {
        return restaurants.stream().filter(
                r -> r.getId().equals(id)
        ).findFirst().orElse(null);
    }
}
