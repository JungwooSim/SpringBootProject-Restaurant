package me.restaurant.application;

import me.restaurant.domain.Reservation;
import me.restaurant.domain.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class ReservationServiceTests {
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); //Mock을 사용할 경우
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    public void addReservation() {
        Long restaurantId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;

        given(reservationRepository.save(any())).will(invocation -> {
            Reservation reservation = invocation.getArgument(0);
            return reservation;
        }); // save 후 받은거 그대로 돌려주기

        Reservation reservation = reservationService.addReservation(
                restaurantId, userId, name, date, time, partySize
        );

        assertThat(reservation.getName(), is(name));

        verify(reservationRepository).save(any(Reservation.class));
    }
}
