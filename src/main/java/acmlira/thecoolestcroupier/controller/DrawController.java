package acmlira.thecoolestcroupier.controller;

import acmlira.thecoolestcroupier.controller.request.DrawRequest;
import acmlira.thecoolestcroupier.model.Draw;
import acmlira.thecoolestcroupier.service.DrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/draw")
public class DrawController {

    @Autowired
    private DrawService drawService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Draw create(@RequestBody DrawRequest drawRequest){

        Draw draw = new Draw();
        draw.setDeckId(drawRequest.getDeckId());
        draw.setCount(drawRequest.getCount());

        return drawService.create(draw);
    }
}