package ru.practicum.explorewithme.statserver.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.practicum.explorewithme.dto.HitDto;
import ru.practicum.explorewithme.dto.StatDto;
import ru.practicum.explorewithme.statserver.db.Hit;
import ru.practicum.explorewithme.statserver.db.Stat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DtoMapper {

    public static Stat fromStatDto(StatDto statDto) {
        return new Stat(
                statDto.getId(),
                statDto.getApp(),
                statDto.getUri(),
                statDto.getIp(),
                LocalDateTime.parse(statDto.getTimestamp(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }

    public static StatDto toStatDto(Stat stat) {
        return new StatDto(
                stat.getId(),
                stat.getApp(),
                stat.getUri(),
                stat.getIp(),
                stat.getTimestamp().toString()
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
