import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AdminService} from "../../service/admin.service";
import {DishCreate} from "../../model/dish-create";

@Component({
  selector: 'app-create-dish',
  templateUrl: './create-dish.component.html',
  styleUrls: ['./create-dish.component.css']
})
export class CreateDishComponent {

  dish: DishCreate;

  constructor(private route: ActivatedRoute, private router: Router, private adminService: AdminService) {
    this.dish = new DishCreate();
  }

  onSubmit() {
    this.adminService.create(this.dish).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['/']);
  }

}
