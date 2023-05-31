package dev.oaymn.digitalbankingbackend.transaction;

import dev.oaymn.digitalbankingbackend.bankaccount.BankAccount;
import dev.oaymn.digitalbankingbackend.transaction.dto.TransactionCreationDTO;
import dev.oaymn.digitalbankingbackend.transaction.dto.TransactionResponseDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.Set;


@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface TransactionMapper {

    Transaction toTransaction(BankAccount account, TransactionCreationDTO creationDTO);

    @Mapping(target = "accountId", source = "transaction.account.id")
    TransactionResponseDTO toTransactionResponse(Transaction transaction);

    Set<TransactionResponseDTO> toTransactionResponseSet(Set<Transaction> transactionSet);

}
