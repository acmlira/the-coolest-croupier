package acmlira.thecoolestcroupier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/draw")
public class DrawController {
    @GetMapping
    public void send(){
        // TODO: nothing
    }
}