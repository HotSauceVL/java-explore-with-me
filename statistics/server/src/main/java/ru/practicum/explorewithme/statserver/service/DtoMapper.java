package ru.practicum.explorewithme.statserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.dto.HitDto;
import ru.practicum.explorewithme.dto.StatDto;
import ru.practicum.explorewithme.statserver.db.Hit;
import ru.practicum.explorewithme.statserver.db.Stat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class DtoMapper {

    public static Stat fromStatDto(StatDto statDto) {
        return new Stat(
                null,
                statDto.getApp(),
                statDto.getUri(),
                statDto.getIp(),
                LocalDateTime.parse(statDto.getTimestamp().toString(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }

    public static StatDto toStatDto(Stat stat) {
        return new StatDto(
                stat.getId(),
                stat.getApp(),
                stat.getUri(),
                stat.getIp(),
                stat.getTimestamp()
        );
    }

    public static HitDto toHitDto(Hit hit) {
        return new HitDto(
                hit.getApp(),
                hit.getUri(),
                hit.getHits()
        );
    }

}
