import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BurgersComponent} from './component/burgers/burgers.component';
import {CheckOutComponent} from './component/check-out/check-out.component';
import {CreateDishComponent} from './component/create-dish/create-dish.component';
import {DesertsComponent} from './component/deserts/deserts.component';
import {DrinksComponent} from './component/drinks/drinks.component';
import {OrdersComponent} from './component/orders/orders.component';
import {OrdersDishesComponent} from './component/orders-dishes/orders-dishes.component';
import {PizzaComponent} from './component/pizza/pizza.component';
import {LoginComponent} from './component/login/login.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {TokenInterceptor} from "./interceptors/token.interceptor";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatSortModule,
  MatTableModule
} from '@angular/material';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    BurgersComponent,
    CheckOutComponent,
    CreateDishComponent,
    DesertsComponent,
    DrinksComponent,
    OrdersComponent,
    OrdersDishesComponent,
    PizzaComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
