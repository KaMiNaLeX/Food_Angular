import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BurgersComponent } from './component/burgers/burgers.component';
import { CheckOutComponent } from './component/check-out/check-out.component';
import { CreateDishComponent } from './component/create-dish/create-dish.component';
import { DesertsComponent } from './component/deserts/deserts.component';
import { DrinksComponent } from './component/drinks/drinks.component';
import { OrdersComponent } from './component/orders/orders.component';
import { OrdersDishesComponent } from './component/orders-dishes/orders-dishes.component';
import { PizzaComponent } from './component/pizza/pizza.component';

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
    PizzaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
