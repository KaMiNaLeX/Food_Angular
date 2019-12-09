import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../service/order.service";
import {ShoppingCartDishDto} from "../../model/shopping-cart-dish-dto";

@Component({
  selector: 'app-orders-dishes',
  templateUrl: './orders-dishes.component.html',
  styleUrls: ['./orders-dishes.component.css']
})
export class OrdersDishesComponent implements OnInit {

  shoppingCartDishes: ShoppingCartDishDto[];

  constructor(private orderService: OrderService) {
  }

  ngOnInit() {
    this.orderService.getDishesByOrderId(+localStorage.getItem('orderId')).subscribe(data => {
      this.shoppingCartDishes = data;
    });
  }

}
