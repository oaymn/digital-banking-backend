package dev.oaymn.digitalbankingbackend.bankaccount.dto;

import dev.oaymn.digitalbankingbackend.common.validationGroups.OnCreate;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record BankAccountCreationDTO (

    @NotBlank(groups = OnCreate.class)
    String currency,

    @NotBlank(groups = OnCreate.class)
    Long ownerId,

    BigDecimal overDraft,
    Double interestRate

) {

}
