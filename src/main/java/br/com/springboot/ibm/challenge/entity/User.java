package br.com.springboot.ibm.challenge.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Pattern(
            regexp = "\\+55 \\d{2} \\d{5}-\\d{4}",
            message = "INVALID_PHONE"
    )
    private String phone;

    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDate;

    @NotBlank
    private String userType;

    public User(User user) {
        this.fullName = user.fullName;
        this.email = user.email;
        this.phone = user.phone;
        this.birthDate = user.birthDate;
        this.userType = user.userType.toLowerCase();
    }

}
