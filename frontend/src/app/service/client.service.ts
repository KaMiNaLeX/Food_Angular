import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = '/clients';
  }

  getById(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getByLogin(login: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/login/${login}`);
  }

  getIdByLogin(login: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/getid/${login}`);
  }


}
