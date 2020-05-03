package me.restaurant.interfaces;

import me.restaurant.application.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void list() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIwMjAsInVzZXJOYW1lIjoiT3duZXIiLCJyZXN0YXVyYW50SWQiOjEwMDR9.zBB7-TCHzVk_4Cun4-ueAEinzePyhThzeJWEyYxlSKQ";

        mvc.perform(get("/reservations")
                .header("Authorization", ":Bearer " + token))
                .andExpect(status().isOk());

        verify(reservationService).getReservations(1004L);

    }
}
