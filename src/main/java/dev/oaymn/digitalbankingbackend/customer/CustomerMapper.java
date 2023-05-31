package dev.oaymn.digitalbankingbackend.customer;

import dev.oaymn.digitalbankingbackend.customer.dto.CustomerCreationDTO;
import dev.oaymn.digitalbankingbackend.customer.dto.CustomerResponseDTO;
import dev.oaymn.digitalbankingbackend.customer.dto.CustomerUpdateDTO;
import org.mapstruct.*;

import java.util.Set;


@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CustomerMapper {

    Customer toCustomer(CustomerCreationDTO creationDTO);

    CustomerResponseDTO toCustomerResponse(Customer customer);

    Set<CustomerResponseDTO> toCustomerResponseSet(Set<Customer> customerSet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDTO(CustomerUpdateDTO updateDTO, @MappingTarget Customer customer);

}
