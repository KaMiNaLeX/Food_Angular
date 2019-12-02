import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/menu';
  }

  findAll(): Observable<Object> {
    return this.http.get(`${this.baseUrl}/?page=0?size=15`);
  }
}
