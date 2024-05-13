package academy.devdojo.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
