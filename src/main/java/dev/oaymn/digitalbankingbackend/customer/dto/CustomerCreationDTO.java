package dev.oaymn.digitalbankingbackend.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CustomerCreationDTO (

    @NotBlank
    String name,

    @NotBlank
    @Email
    String email

) {

}
