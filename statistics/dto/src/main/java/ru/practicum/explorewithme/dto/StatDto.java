package ru.practicum.explorewithme.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class StatDto {
    private Long id;
    @NotNull
    @NotBlank
    private String app;
    @NotNull
    @NotBlank
    private String uri;
    @NotBlank
    private String ip;
    @NotNull
    private String timestamp;
}
