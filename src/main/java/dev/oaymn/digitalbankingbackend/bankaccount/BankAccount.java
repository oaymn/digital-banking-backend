package dev.oaymn.digitalbankingbackend.bankaccount;

import dev.oaymn.digitalbankingbackend.common.AbstractEntity;
import dev.oaymn.digitalbankingbackend.customer.Customer;
import dev.oaymn.digitalbankingbackend.operation.AccountOperation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 2)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccount extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private BigDecimal balance;

    @Column(nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private Customer owner;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccountOperation> operations;

    @CreatedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime updatedAt;

    @Override
    protected void prePersist() {
        super.prePersist();

        if (balance == null) {
            balance = BigDecimal.ZERO;
        }

        if (status == null) {
            status = AccountStatus.CREATED;
        }
    }
}
