package first.time.runner2.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty
         String firstname,
        @NotEmpty
        String lastname,
         @NotEmpty
         String email,
        Integer schoolId
) {
}
