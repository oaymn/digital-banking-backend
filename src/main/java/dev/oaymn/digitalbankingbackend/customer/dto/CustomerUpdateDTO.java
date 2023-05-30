package dev.oaymn.digitalbankingbackend.customer.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record CustomerUpdateDTO (
    @Email
    String email

) {

}
