import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dish} from "../model/dish";
import {DishCreate} from "../model/dish-create";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/admin';
  }

  public create(dish: DishCreate): Observable<DishCreate> {
    return this.http.post<DishCreate>(`${this.baseUrl}/create`, dish);
  }
}
