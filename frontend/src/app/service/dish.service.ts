import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dish} from "../model/dish";

@Injectable({
  providedIn: 'root'
})
export class DishService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/dishes';
  }

  findAll(): Observable<Object> {
    return this.http.get(`${this.baseUrl}/?page=0?size=15`);
  }

  findAllDishesMenu(): Observable<Object> {
    return this.http.get(`${this.baseUrl}/menu/`);
  }

  getById(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getAllDishesByCategory(category: string): Observable<Dish[]> {
    return this.http.get<Dish[]>(`${this.baseUrl}/category/${category}`);
  }

  getByIdDTO(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/id/${id}`);
  }
}
