import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order";
import {Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: Order[];
  order: Order = new Order();
  showDeleteMessage = "";

  constructor(private orderService: OrderService, private router: Router) {
  }

  ngOnInit() {
    this.orderService.getAllOrdersByLogin(localStorage.getItem('username')).subscribe(data => {
      this.orders = data;
    });
  }

  details(id: number) {
    localStorage.removeItem('orderId');
    localStorage.setItem('orderId', id.toString());
    this.router.navigate(['orderDish']);
  }

  delete(id: number) {
    this.orderService.delete(id).subscribe(data => {
      this.showDeleteMessage = data;
    });
    window.alert("Order remove!");
    this.orderService.getAllOrdersByLogin(localStorage.getItem('username')).subscribe(data => {
      this.orders = data;
    });
  }

  deleteAll() {
    let clientId = localStorage.getItem("id");
    this.orderService.deleteAll(+clientId).subscribe(data => {
      this.showDeleteMessage = data;
    });
    window.alert("All orders removed!");
    this.orderService.getAllOrdersByLogin(localStorage.getItem('username')).subscribe(data => {
      this.orders = data;
    });
  }

}
