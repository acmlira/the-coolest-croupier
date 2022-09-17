package acmlira.thecoolestcroupier.controller;

import acmlira.thecoolestcroupier.controller.request.DrawRequest;
import acmlira.thecoolestcroupier.dto.DrawDTO;
import acmlira.thecoolestcroupier.service.DrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/draw")
public class DrawController {

    @Autowired
    private DrawService drawService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DrawDTO create(@RequestBody DrawRequest drawRequest){

        DrawDTO drawDTO = new DrawDTO();
        drawDTO.setDeckId(drawRequest.getDeckId());
        drawDTO.setCount(drawRequest.getCount());
        drawDTO.setCards(new ArrayList<>());

        return drawService.create(drawDTO);
    }
}