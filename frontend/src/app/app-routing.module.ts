import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./component/auth/login/login.component";
import {RegisterComponent} from "./component/auth/register/register.component";
import {PizzaComponent} from "./component/pizza/pizza.component";
import {BurgersComponent} from "./component/burgers/burgers.component";
import {DesertsComponent} from "./component/deserts/deserts.component";
import {DrinksComponent} from "./component/drinks/drinks.component";
import {OrdersDishesComponent} from "./component/orders-dishes/orders-dishes.component";
import {CheckOutComponent} from "./component/check-out/check-out.component";


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registry', component: RegisterComponent},
  {path: 'pizza', component: PizzaComponent},
  {path: 'burgers', component: BurgersComponent},
  {path: 'deserts', component: DesertsComponent},
  {path: 'drinks', component: DrinksComponent},
  {path: 'orders', component: OrdersDishesComponent},
  {path: 'checkout', component: CheckOutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
