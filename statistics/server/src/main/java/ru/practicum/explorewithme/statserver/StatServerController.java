package ru.practicum.explorewithme.statserver;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explorewithme.dto.HitDto ;
import ru.practicum.explorewithme.dto.StatDto ;
import ru.practicum.explorewithme.statserver.service.DtoMapper;
import ru.practicum.explorewithme.statserver.service.StatService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
public class StatServerController {
    private final StatService statsService;

    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.CREATED)
    public StatDto hit(@Valid @RequestBody StatDto statDto) {
        return DtoMapper.toStatDto(statsService.create(DtoMapper.fromStatDto(statDto)));
    }

    @GetMapping("/stats")
    public List<HitDto> get(@RequestParam(name = "start") LocalDateTime start,
                            @RequestParam(name = "end") LocalDateTime end,
                            @RequestParam(name = "uris", required = false) List<String> uris,
                            @RequestParam(name = "unique", defaultValue = "false") Boolean unique) {
        return statsService.get(start, end, uris, unique).stream()
                .map(DtoMapper::toHitDto).collect(Collectors.toList());
    }
}
