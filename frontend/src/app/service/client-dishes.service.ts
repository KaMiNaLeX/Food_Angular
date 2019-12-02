import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientDishesService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/clients/dishes';
  }

  findAll(): Observable<Object> {
    return this.http.get(`${this.baseUrl}/`);
  }
}
