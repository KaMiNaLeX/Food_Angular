package com.example.food.controllers;

import com.example.food.dto.adminDto.OrdersDto;
import com.example.food.services.ClientsService;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ClientsService clientsService;

    @PostMapping("/create")
    public OrdersDto createOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.createOrders(ordersDto);
    }

    @GetMapping("/")
    public List getAllOrders(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return ordersService.getAllOrders(page, size);
    }

    @GetMapping("/id/{id}")
    public OrdersDto getOrderById(@PathVariable("id") Long id) {
        return ordersService.getOrderById(id);
    }

    @GetMapping("/login/{login}")
    public List getAllOrdersParam(@PathVariable("login") String login, Principal principal) {
        if (!principal.getName().equals(login)) {
            return new ArrayList();

        }

        return ordersService.getAllOrdersParam(login);
    }

    @GetMapping("/{login}")
    public List getDishesByLogin(@PathVariable("login") String login, Principal principal) {
        if (!principal.getName().equals(login)) {
            return new ArrayList();

        }
        return ordersService.getDishesByLogin(login);
    }

    @DeleteMapping("/delete/{orderId}")
    public void delete(@PathVariable("orderId") Long orderId, Principal principal) {
        //current log-in clientId
        BigInteger id = clientsService.getByLogin(principal.getName()).getId();
        //clientId по запросу
        BigInteger clientId = ordersService.getOrderById(orderId).getClientId();
        if (!id.equals(clientId)) {

        } else {
            ordersService.delete(orderId);
        }
    }

    @DeleteMapping("/deleteAll/{clientId}")
    public void deleteAll(@PathVariable("clientId") Long clientId, Principal principal) {
        //current log-in clientId
        BigInteger id = clientsService.getByLogin(principal.getName()).getId();
        BigInteger clientid = clientsService.getById(clientId).getId();
        if (!id.equals(clientid)) {

        } else {
            ordersService.deleteAll(clientId);
        }
    }

    @GetMapping("/orderId/{orderId}")
    public List getDishesByOrderId(@PathVariable("orderId") Long orderId, Principal principal) {
        //current log-in clientId
        BigInteger id = clientsService.getByLogin(principal.getName()).getId();
        //clientId по запросу
        BigInteger clientid = ordersService.getOrderById(orderId).getClientId();
        if (!id.equals(clientid)) {
            return new ArrayList();

        } else {
            return ordersService.getDishesByOrderId(orderId);
        }
    }
}
