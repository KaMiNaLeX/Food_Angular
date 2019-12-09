import {Component, OnInit} from '@angular/core';
import {ShoppingCartService} from "../../service/shopping-cart.service";
import {ShoppingCartDishDto} from "../../model/shopping-cart-dish-dto";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order";
import {Dish} from "../../model/dish";

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {

  shoppingCartDishes: ShoppingCartDishDto[];
  order: Order = new Order();
  login: string;
  showDeleteMessage = "";

  constructor(private shoppingCartService: ShoppingCartService, private orderService: OrderService) {
  }

  ngOnInit() {
    this.login = localStorage.getItem('username');
    this.shoppingCartService.getByLogin(this.login).subscribe(data => {
      this.shoppingCartDishes = data;
    });
  }

  createOrder(count: number) {
    if (count != 0) {
      window.alert("Order created!");
      var i = 0;
      var clientId = localStorage.getItem('id');
      this.order.timeOrder = new Date();
      this.order.clientId = +clientId;
      this.order.sum = 0;
      this.order.dishesDtoList = new Array<Dish>();
      for (i; i < count; i++) {
        var dish = new Dish();
        dish.description = document.getElementsByName('description')[i].textContent;
        dish.id = +document.getElementsByName('dishId')[i].textContent;
        dish.img_source = (<HTMLImageElement>document.getElementsByName('img_source')[i]).src.split("http://localhost:4200").join("");
        dish.name = document.getElementsByName('name')[i].textContent;
        dish.mass = +document.getElementsByName('mass')[i].textContent;
        dish.menu_id = +document.getElementsByName('menuId')[i].textContent;
        this.order.sum += +document.getElementsByName("cost")[i].textContent;
        this.order.dishesDtoList.push(dish);
      }
      this.orderService.create(this.order).subscribe(data => {
        this.order = data;
      });
    } else {
      window.alert("Shopping cart is Empty!");
    }

  }

  delete(id: number) {
    this.shoppingCartService.delete(id).subscribe(data => {
      this.showDeleteMessage = data;
    });
    window.alert("Dish remove from shopping cart!");
    window.location.reload();
  }

  deleteAll(count: number) {
    var i = 0;
    var id;
    for (i; i < count; i++) {
      id = document.getElementsByName("id")[i].textContent;
      this.shoppingCartService.delete(id).subscribe(data => {
        this.showDeleteMessage = data;
      });
    }
    window.alert("Now Shopping cart is empty!");
    window.location.reload();
  }
}
