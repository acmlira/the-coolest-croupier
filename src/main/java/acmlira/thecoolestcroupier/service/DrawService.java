package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.dto.DrawDTO;
import org.springframework.stereotype.Service;

@Service
public class DrawService {
    public DrawDTO create(DrawDTO drawDTO) {
        return drawDTO;
    }
}
