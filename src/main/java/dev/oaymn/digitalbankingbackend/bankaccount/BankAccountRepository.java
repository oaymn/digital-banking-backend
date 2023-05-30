package dev.oaymn.digitalbankingbackend.bankaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Set<BankAccount> findAllByOwnerId(Long ownerId);

}
