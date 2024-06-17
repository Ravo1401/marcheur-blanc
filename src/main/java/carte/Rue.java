package carte;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rue {
    private Lieu origine;
    private Lieu destination;
}