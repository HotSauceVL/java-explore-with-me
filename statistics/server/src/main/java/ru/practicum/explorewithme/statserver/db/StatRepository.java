package ru.practicum.explorewithme.statserver.db;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.explorewithme.dto.HitDto;
import ru.practicum.explorewithme.dto.StatDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatRepository extends JpaRepository<Stat, Long> {

    @Query(nativeQuery = true, value="SELECT s.app AS app, s.uri AS uri, COUNT(s.uri) AS hits " +
            "FROM stats AS s " +
            "WHERE ((s.time_stamp between ?1 AND ?2) " +
            "AND (?3 is null or s.uri in ?3))" +
            "GROUP BY s.app, s.uri")
    List<Hit> getStats(LocalDateTime start, LocalDateTime end, List<String> uris);

    @Query(nativeQuery = true, value="SELECT s.app AS app, s.uri AS uri, COUNT(s.uri) AS hits " +
            "FROM (SELECT DISTINCT ip AS i, * " +
            "FROM stats) AS s " +
            "WHERE ((s.time_stamp between ?1 AND ?2) " +
            "AND (?3 is null or s.uri in ?3))" +
            "GROUP BY s.app, s.uri")
    List<Hit> getStatWithUniqueIp(LocalDateTime start, LocalDateTime end, List<String> uris);

}
