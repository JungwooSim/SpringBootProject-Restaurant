package me.restaurant.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    private Long userId;

    private String name;

    @NotEmpty
    private String date;

    @NotEmpty
    private String time;

    @NotNull
    private Integer partySize;
}
