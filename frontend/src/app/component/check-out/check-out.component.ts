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

  dishesDtoList: Dish[];
  showDeleteMessage = false;

  constructor(private shoppingCartService: ShoppingCartService, private orderService: OrderService) {
  }

  ngOnInit() {
    this.login = localStorage.getItem('username');
    this.shoppingCartService.getByLogin(this.login).subscribe(data => {
      this.shoppingCartDishes = data;
    });
  }

  createOrder(count: number) {
    var i = 0;
    var clientId = localStorage.getItem('id');
    this.order.timeOrder = new Date();
    this.order.clientId = +clientId;
    this.order.sum = 200;
    this.order.dishesDtoList = new Array<Dish>();
    for (i; i < count; i++) {
      var dish = new Dish();
      dish.description = document.getElementsByName('description')[i].textContent;
      dish.id = +document.getElementsByName('dishId')[i].textContent;
      dish.img_source = (<HTMLImageElement>document.getElementsByName('img_source')[i]).src.split("http://localhost:4200").join("");
      dish.name = document.getElementsByName('name')[i].textContent;
      dish.mass = +document.getElementsByName('mass')[i].textContent;
      dish.menu_id = +document.getElementsByName('menuId')[i].textContent;
      this.order.dishesDtoList.push(dish);
    }
    this.orderService.create(this.order).subscribe(data => {
      this.order = data;
    });
    window.alert("Order created!")
  }
}
