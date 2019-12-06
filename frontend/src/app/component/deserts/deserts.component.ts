import {Component, OnInit} from '@angular/core';
import {Dish} from "../../model/dish";
import {ShoppingCart} from "../../model/shopping-cart";
import {DishService} from "../../service/dish.service";
import {ShoppingCartService} from "../../service/shopping-cart.service";

@Component({
  selector: 'app-deserts',
  templateUrl: './deserts.component.html',
  styleUrls: ['./deserts.component.css']
})
export class DesertsComponent implements OnInit {

  deserts: Dish[];
  desert: Dish = new Dish();
  category: string;
  shoppingCart: ShoppingCart = new ShoppingCart();
  showDeleteMessage = false;

  constructor(private dishService: DishService, private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
    this.category = localStorage.getItem('desert');
    this.dishService.getAllDishesByCategory(this.category).subscribe(data => {
      this.deserts = data;
    });
  }

  addToShoppingCart(id: number) {
    var clientId = localStorage.getItem('id');
    this.shoppingCart.clientId = +clientId;
    this.shoppingCart.dishId = id;
    this.shoppingCartService.create(this.shoppingCart).subscribe(data => {
      this.shoppingCart = data;
    });
    window.alert("Dish add to cart!")
  }

}
