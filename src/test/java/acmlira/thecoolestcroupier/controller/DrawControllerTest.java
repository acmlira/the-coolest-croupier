package acmlira.thecoolestcroupier.controller;

import acmlira.thecoolestcroupier.controller.request.DrawRequest;
import acmlira.thecoolestcroupier.dto.DrawDTO;
import acmlira.thecoolestcroupier.service.DrawService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class DrawControllerTest {

    @InjectMocks
    private DrawController drawController;

    @Mock
    private DrawService drawService;


    @Test
    public void create() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        DrawDTO drawDTO = new DrawDTO();
        drawDTO.setDeckId(UUID.randomUUID());
        drawDTO.setCount(0);
        drawDTO.setCards(new ArrayList<>());

        when(drawService.create(any())).thenReturn(drawDTO);

        DrawRequest drawRequest = new DrawRequest();
        drawRequest.setDeckId(drawDTO.getDeckId());
        drawRequest.setCount(drawDTO.getCount());

        assertThat(drawController.create(drawRequest)).isEqualTo(drawDTO);
    }


}
