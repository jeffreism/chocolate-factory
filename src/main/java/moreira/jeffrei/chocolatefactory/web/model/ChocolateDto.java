package moreira.jeffrei.chocolatefactory.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDto {
    private UUID id;
    private String name;
    private String style;
    private Long code;
}
