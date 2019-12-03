import {Component, OnInit} from '@angular/core';
import {DishService} from "../../service/dish.service";
import {Dish} from "../../model/dish";

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {

  pizzas: Dish[];
  pizza: Dish = new Dish();
  category: string;
  showDeleteMessage = false;

  constructor(private dishService: DishService) {
  }

  ngOnInit() {
    this.category = localStorage.getItem('pizza');
    this.dishService.getAllDishesByCategory(this.category).subscribe(data => {
      this.pizzas = data;
    });
  }

}
