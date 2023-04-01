package ru.practicum.explorewithme.statserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.dto.HitDto;
import ru.practicum.explorewithme.statserver.db.Hit;
import ru.practicum.explorewithme.statserver.db.Stat;
import ru.practicum.explorewithme.statserver.db.StatRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    @Override
    public Stat create(Stat stat) {
        Stat savedStat = statRepository.save(stat);
        log.debug("stat saved: {}", savedStat);
        return savedStat;
    }

    @Override
    public List<Hit> get(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        if (unique)
            return statRepository.getStatWithUniqueIp(start, end, (uris == null ? Collections.emptyList() : uris));
        else
            return statRepository.getStats(start, end, (uris == null ? Collections.emptyList() : uris));
    }
}
