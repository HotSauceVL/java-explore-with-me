package ru.practicum.explorewithme.statserver.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hit {
    private String app;
    private String uri;
    private Long hits;
}
