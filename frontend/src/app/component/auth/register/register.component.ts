import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, NgForm, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../../../service/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  surname = '';
  phone = '';
  login = '';
  address = '';
  password = '';
  isLoadingResults = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      'surname': [null, Validators.required],
      'phone': [null, Validators.required],
      'login': [null, Validators.required],
      'address': [null, Validators.required],
      'password': [null, Validators.required]
    });
  }

  onFormSubmit(form: NgForm) {
    this.authService.register(form)
      .subscribe(res => {
        if (res == null) {
          window.alert("Login is used!")
        } else {
          window.alert("Registration is success!");
          this.router.navigate(['login']);
        }

      }, (err) => {
        console.log(err);
        alert(err.error);
      });
  }

  loginPage() {
    this.router.navigate(['login']);
  }

}
