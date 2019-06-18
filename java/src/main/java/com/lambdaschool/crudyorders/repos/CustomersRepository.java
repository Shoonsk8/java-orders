package com.lambdaschool.crudyorders.repos;

import com.lambdaschool.crudyorders.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Long>
{
    Customers findByCustname(String name);
}
