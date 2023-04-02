package ru.practicum.explorewithme.statserver.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StatRepository extends JpaRepository<Stat, Long> {

    @Query("SELECT new ru.practicum.explorewithme.statserver.db.Hit (s.app, s.uri, COUNT(s.ip)) " +
            "FROM Stat s " +
            "WHERE s.timestamp >= :start " +
            "AND s.timestamp <= :end " +
            "GROUP BY s.app, s.uri " +
            "ORDER BY count(s.ip) desc")
    List<Hit> getStats(@Param("start") LocalDateTime start,
                       @Param("end") LocalDateTime end);

    @Query("SELECT new ru.practicum.explorewithme.statserver.db.Hit (s.app, s.uri, COUNT(DISTINCT s.ip)) " +
            "FROM Stat s " +
            "WHERE s.timestamp >= :start " +
            "AND s.timestamp <= :end " +
            "GROUP BY s.app, s.uri " +
            "ORDER BY count(DISTINCT s.ip) Desc")
    List<Hit> getStatWithUniqueIp(@Param("start") LocalDateTime start,
                                  @Param("end") LocalDateTime end);

}
