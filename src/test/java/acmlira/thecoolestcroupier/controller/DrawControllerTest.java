package acmlira.thecoolestcroupier.controller;

import acmlira.thecoolestcroupier.controller.request.DrawRequest;
import acmlira.thecoolestcroupier.mock.DrawMock;
import acmlira.thecoolestcroupier.model.Draw;
import acmlira.thecoolestcroupier.service.DrawService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

        Draw draw = DrawMock.getDraw();

        when(drawService.create(any())).thenReturn(draw);

        DrawRequest drawRequest = new DrawRequest();
        drawRequest.setDeckId(draw.getDeckId());
        drawRequest.setCount(draw.getCount());

        assertEquals(drawController.create(drawRequest), draw);
    }
}
