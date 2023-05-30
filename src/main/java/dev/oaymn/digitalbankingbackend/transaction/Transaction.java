package dev.oaymn.digitalbankingbackend.transaction;

import dev.oaymn.digitalbankingbackend.bankaccount.BankAccount;
import dev.oaymn.digitalbankingbackend.common.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private TransactionType type;

    @Column(nullable = false, updatable = false)
    private BigDecimal amount;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BankAccount account;

    @Column(updatable = false)
    private String description;

    @CreatedDate
    @Setter(AccessLevel.NONE)
    @Column(updatable = false)
    private LocalDateTime timestamp;

}
