package dev.oaymn.digitalbankingbackend.bankaccount;

import dev.oaymn.digitalbankingbackend.bankaccount.dto.BankAccountCreationDTO;
import dev.oaymn.digitalbankingbackend.bankaccount.dto.BankAccountResponseDTO;
import dev.oaymn.digitalbankingbackend.bankaccount.dto.BankAccountUpdateDTO;
import dev.oaymn.digitalbankingbackend.customer.Customer;
import org.mapstruct.*;

import java.util.Set;


@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface BankAccountMapper {

    BankAccount toBankAccount(Customer owner, BankAccountCreationDTO creationDTO);

    @SubclassMapping(target = BankAccountResponseDTO.class, source = MainAccount.class)
    @SubclassMapping(target = BankAccountResponseDTO.class, source = SavingAccount.class)
    BankAccountResponseDTO toBankAccountResponse(BankAccount bankAccount);

    Set<BankAccountResponseDTO> toBankAccountResponseSet(Set<BankAccount> bankAccountSet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMainAccountFromDTO(BankAccountUpdateDTO updateDTO, @MappingTarget MainAccount mainAccount);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSavingAccountFromDTO(BankAccountUpdateDTO updateDTO, @MappingTarget SavingAccount savingAccount);

}
