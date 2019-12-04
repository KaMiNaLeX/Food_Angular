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

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
    this.authenticated = false;
  }

  pizza() {
    localStorage.setItem('pizza', 'Pizza')
    this.router.navigate(['pizza']);
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
