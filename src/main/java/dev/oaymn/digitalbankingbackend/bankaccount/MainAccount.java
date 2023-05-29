package dev.oaymn.digitalbankingbackend.bankaccount;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("MA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainAccount extends BankAccount {

    private BigDecimal overDraft;

    @Override
    protected void prePersist() {
        super.prePersist();

        if (overDraft == null) {
            overDraft = BigDecimal.ZERO;
        }
    }
}
