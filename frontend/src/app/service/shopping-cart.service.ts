import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ShoppingCart} from "../model/shopping-cart";
import {Observable} from "rxjs";
import {ShoppingCartDishDto} from "../model/shopping-cart-dish-dto";

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/shoppingCart';
  }

  public create(shoppingCart: ShoppingCart) {
    return this.http.post<ShoppingCart>(`${this.baseUrl}/create`, shoppingCart);
  }

  findAll(): Observable<Object> {
    return this.http.get(`${this.baseUrl}/?page=0?size=15`);
  }

  getByLogin(login: string): Observable<ShoppingCartDishDto[]> {
    return this.http.get<ShoppingCartDishDto[]>(`${this.baseUrl}/${login}`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }
}
