import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dish} from "../model/dish";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/admin';
  }

  public create(dish: Dish): Observable<Dish> {
    return this.http.post<Dish>(`${this.baseUrl}/create`, dish);
  }
}
