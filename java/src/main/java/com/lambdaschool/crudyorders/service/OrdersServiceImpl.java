package com.lambdaschool.crudyorders.service;


import com.lambdaschool.crudyorders.model.Orders;
import com.lambdaschool.crudyorders.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "OrdersService")
public class OrdersServiceImpl implements OrdersService
{
  @Autowired
    private OrdersRepository orderepos;


    @Override
    public ArrayList<Orders> findAll()
    {
        ArrayList<Orders> list = new ArrayList<>();
        orderepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Orders findOrdersById(long id)
    {
        return orderepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Orders findOrdersByName(String name)
    {
        Orders Orders = orderepos.findByName(name);

        if (Orders == null)
        {
            throw new EntityNotFoundException("Orders " + name + " not found!");
        }

        return Orders;
    }

    @Override
    public void delete(long id)
    {
        if (orderepos.findById(id).isPresent())
        {
            orderepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }



    @Transactional
    @Override
    public Orders save(Orders ord)
    {

        Orders newOrders = new Orders(ord.getOrdamount(),
                ord.getAdvanceamount(),
                ord.getCustomer(),
                ord.getAgent(),
                ord.getOrdersescription());

        // newOrders.setMenus(Orders.getMenus());

        return orderepos.save(newOrders);
    }

    @Transactional
    @Override
    public Orders update(Orders ord, long id)
    {
        Orders currentOrders = orderepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        currentOrders.setOrdamount(ord.getOrdnum());
        currentOrders.setAdvanceamount(ord.getAdvanceamount());
        if (ord.getOrdersescription() != null)currentOrders.setOrdersescription(ord.getOrdersescription());
        if (ord.getCustomer() != null)currentOrders.setCustomer(ord.getCustomer());
        if (ord.getAgent() != null)currentOrders.setAgent(ord.getAgent());

        return orderepos.save(currentOrders);
    }
}

