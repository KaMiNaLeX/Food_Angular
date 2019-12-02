import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../model/order";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/orders';
  }

  public create(order: Order) {
    return this.http.post<Order>(`${this.baseUrl}/create`, order);
  }

  findAll(): Observable<Object> {
    return this.http.get(`${this.baseUrl}/?page=0?size=15`);
  }

  getByIdDTO(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/id/${id}`);
  }

  getAllOrdersByLogin(login: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/login/${login}`);
  }

  getDishesByLogin(login: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${login}`);
  }

  getDishesByOrderId(orderId: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/orderId/${orderId}`);
  }
}
