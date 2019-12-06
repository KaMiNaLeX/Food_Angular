import {Component} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "./service/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  principal = null;
  authenticated = false;
  div1: boolean = true;

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
    this.authenticated = false;
  }

  pizza() {
    localStorage.setItem('pizza', 'Pizza');
    this.router.navigate(['pizza']);
    this.div1 = false;
  }

  burgers() {
    localStorage.setItem('burger', 'Burger');
    this.router.navigate(['burgers']);
    this.div1 = false;
  }

  drinks() {
    localStorage.setItem('drink', 'Drink');
    this.router.navigate(['drinks']);
    this.div1 = false;
  }

  deserts() {
    localStorage.setItem('desert', 'Dessert');
    this.router.navigate(['deserts']);
    this.div1 = false;
  }

  shoppingCart() {
    this.router.navigate(['checkout']);
  }

  orders() {
    this.router.navigate(['orders']);
  }

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthService,
              private http: HttpClient) {
    this.authenticate();
  }

  authenticate() {
    this.principal = this.authService.principal();
    if (this.principal != null) {
      this.authenticated = true;
    } else this.authenticated = false;
  }
}
