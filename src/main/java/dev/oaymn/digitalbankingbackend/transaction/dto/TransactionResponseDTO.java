package dev.oaymn.digitalbankingbackend.transaction.dto;

import dev.oaymn.digitalbankingbackend.transaction.TransactionType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TransactionResponseDTO(

    long id,
    TransactionType type,
    long accountId,
    BigDecimal amount,
    String description

) {
}
