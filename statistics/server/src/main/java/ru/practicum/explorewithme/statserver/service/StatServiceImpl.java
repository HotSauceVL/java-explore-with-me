package ru.practicum.explorewithme.statserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.statserver.db.Hit;
import ru.practicum.explorewithme.statserver.db.Stat;
import ru.practicum.explorewithme.statserver.db.StatRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    @Override
    public Stat create(Stat stat) {
        Stat savedStat = statRepository.save(stat);
        log.info("stat saved: App {}, Uri {}, Ip {}", savedStat.getApp(), savedStat.getUri(), savedStat.getIp());
        return savedStat;
    }

    @Override
    public List<Hit> get(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        log.info("get stat with start {}, end {}, uris {}, unique {}", start, end, uris, unique);
        if (unique)
            return uris != null && uris.size() != 0 ? statRepository.getStatWithUniqueIp(start, end).stream()
                    .filter(result -> uris.contains(result.getUri())).collect(Collectors.toList())
                    : statRepository.getStatWithUniqueIp(start, end);
        else
            return uris != null && uris.size() != 0 ? statRepository.getStats(start, end).stream()
                    .filter(result -> uris.contains(result.getUri())).collect(Collectors.toList())
                    : statRepository.getStats(start, end);
    }
}
