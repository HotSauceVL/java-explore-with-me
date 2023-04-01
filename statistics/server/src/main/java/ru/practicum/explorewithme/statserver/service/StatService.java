package ru.practicum.explorewithme.statserver.service;

import ru.practicum.explorewithme.statserver.db.Hit;
import ru.practicum.explorewithme.statserver.db.Stat;

import java.time.LocalDateTime;
import java.util.List;

public interface StatService {

    Stat create(Stat stat);

    List<Hit> get(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique);

}
