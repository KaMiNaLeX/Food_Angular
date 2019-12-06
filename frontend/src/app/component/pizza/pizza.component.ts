import {Component, OnInit} from '@angular/core';
import {DishService} from "../../service/dish.service";
import {Dish} from "../../model/dish";
import {ShoppingCartService} from "../../service/shopping-cart.service";
import {ShoppingCart} from "../../model/shopping-cart";

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {

  pizzas: Dish[];
  pizza: Dish = new Dish();
  category: string;
  shoppingCart: ShoppingCart = new ShoppingCart();
  showDeleteMessage = false;

  constructor(private dishService: DishService, private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.category = localStorage.getItem('pizza');
    this.dishService.getAllDishesByCategory(this.category).subscribe(data => {
      this.pizzas = data;
    });
  }

  addToShoppingCart(id: number) {
    var clientId = localStorage.getItem('id');
    this.shoppingCart.clientId = +clientId;
    this.shoppingCart.dishId = id;
    this.shoppingCartService.create(this.shoppingCart).subscribe(data => {
      this.shoppingCart = data;
    });
    if (clientId != null) {
      window.alert("Dish add to cart!");
    } else window.alert("Need to login or registration!")
  }

}
