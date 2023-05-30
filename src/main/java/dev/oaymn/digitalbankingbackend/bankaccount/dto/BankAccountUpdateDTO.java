package dev.oaymn.digitalbankingbackend.bankaccount.dto;

import dev.oaymn.digitalbankingbackend.bankaccount.dto.validationgroups.OnMainAccountUpdate;
import dev.oaymn.digitalbankingbackend.bankaccount.dto.validationgroups.OnSavingAccountUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record BankAccountUpdateDTO (

    @NotNull(groups = OnMainAccountUpdate.class)
    @PositiveOrZero(groups = OnMainAccountUpdate.class)
    BigDecimal overDraft,

    @NotNull(groups = OnSavingAccountUpdate.class)
    @PositiveOrZero(groups = OnSavingAccountUpdate.class)
    Double interestRate

) {

}
