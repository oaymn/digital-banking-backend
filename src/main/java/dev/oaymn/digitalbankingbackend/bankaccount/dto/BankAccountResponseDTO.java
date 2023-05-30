package dev.oaymn.digitalbankingbackend.bankaccount.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.oaymn.digitalbankingbackend.bankaccount.AccountStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record BankAccountResponseDTO(

    Long id,
    String currency,
    BigDecimal balance,
    AccountStatus status,
    Long ownerId,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    BigDecimal overDraft,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Double interestRate,

    LocalDateTime createdAt,
    LocalDateTime updatedAt

) {

}
