package com.lambdaschool.crudyorders.service;

import com.lambdaschool.crudyorders.model.Orders;

import java.util.ArrayList;

public interface OrdersService
{
    ArrayList<Orders> findAll();

    Orders findOrdersById(long id);

    Orders findOrdersByName(String name);

    void delete(long id);

    Orders save(Orders orders);

    Orders update(Orders orders, long id);
}
