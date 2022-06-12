package edu.calendaroflife.dto.user;

import edu.calendaroflife.converter.Convertible;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Data
public class SuccessLogin implements Convertible {
    private Long id;
    private String email;
    private String accessToken;
}
