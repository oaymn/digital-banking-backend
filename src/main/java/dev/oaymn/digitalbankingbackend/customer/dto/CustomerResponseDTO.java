package dev.oaymn.digitalbankingbackend.customer.dto;

import lombok.Builder;

@Builder
public record CustomerResponseDTO (

    long id,
    String name,
    String email

) {

}
