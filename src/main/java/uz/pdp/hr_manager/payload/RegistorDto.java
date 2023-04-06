package uz.pdp.hr_manager.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistorDto {
    @Size(min = 3,max = 50)
    private String firstName;
    @Size(min = 3,max = 50)
    private String lastName;
    @Email
    private String email;
    @NotNull
    private String password;
}
