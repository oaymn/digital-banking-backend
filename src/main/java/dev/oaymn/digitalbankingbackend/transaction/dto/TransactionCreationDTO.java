package dev.oaymn.digitalbankingbackend.transaction.dto;

import dev.oaymn.digitalbankingbackend.transaction.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TransactionCreationDTO(

    @NotNull
    TransactionType type,

    @NotNull
    @Positive
    BigDecimal amount,

    String description

) {
}
