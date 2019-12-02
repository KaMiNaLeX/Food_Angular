package com.example.food.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/check-out")
    public String checkout() {
        return "check-out";
    }

    @RequestMapping(value = "/listing")
    public String listing() {
        return "listing";
    }

    @RequestMapping(value = "/single")
    public String single() {
        return "single";
    }

    @RequestMapping(value = "/orders")
    public String orders() {
        return "orders";
    }

    @RequestMapping(value = "/burgers")
    public String burgers() {
        return "burgers";
    }

    @RequestMapping(value = "/deserts")
    public String deserts() {
        return "deserts";
    }

    @RequestMapping(value = "/drinks")
    public String drinks() {
        return "drinks";
    }

    @RequestMapping(value = "/pizza")
    public String pizza() {
        return "pizza";
    }

    @RequestMapping(value = "/ordersDishes")
    public String ordersDishes() {
        return "ordersDishes";
    }

    @RequestMapping(value = "/createDish")
    public String createDish() {
        return "createDish";
    }
}
