import {Component, OnInit} from '@angular/core';
import {Dish} from "../../model/dish";
import {ShoppingCart} from "../../model/shopping-cart";
import {DishService} from "../../service/dish.service";
import {ShoppingCartService} from "../../service/shopping-cart.service";

@Component({
  selector: 'app-drinks',
  templateUrl: './drinks.component.html',
  styleUrls: ['./drinks.component.css']
})
export class DrinksComponent implements OnInit {

  drinks: Dish[];
  drink: Dish = new Dish();
  category: string;
  shoppingCart: ShoppingCart = new ShoppingCart();
  showDeleteMessage = false;

  constructor(private dishService: DishService, private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.category = localStorage.getItem('drink');
    this.dishService.getAllDishesByCategory(this.category).subscribe(data => {
      this.drinks = data;
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
