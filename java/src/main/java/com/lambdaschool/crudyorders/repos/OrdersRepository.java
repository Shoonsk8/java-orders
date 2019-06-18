package com.lambdaschool.crudyorders.repos;

import com.lambdaschool.crudyorders.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long>
{

}
