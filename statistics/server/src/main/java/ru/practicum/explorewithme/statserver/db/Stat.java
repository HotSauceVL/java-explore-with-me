package ru.practicum.explorewithme.statserver.db;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stats")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="app")
    private String app;

    @Column(name="uri")
    private String uri;

    @Column(name="ip")
    private String ip;

    @Column(name="time_stamp")
    private LocalDateTime timestamp;
}
