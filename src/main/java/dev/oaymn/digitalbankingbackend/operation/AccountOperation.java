package dev.oaymn.digitalbankingbackend.operation;

import dev.oaymn.digitalbankingbackend.bankaccount.BankAccount;
import dev.oaymn.digitalbankingbackend.common.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountOperation extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private OperationType type;

    @Column(nullable = false, updatable = false)
    private BigDecimal amount;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private BankAccount account;

    @CreatedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime dateTime;

}
