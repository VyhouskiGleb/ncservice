import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'

})
export class HttpClientService {

  constructor(private  http: HttpClient) { }

  get(url: string): Observable<any> {
    return this.http.get(url);
  }
  put(url: string, data: any): Observable<any> {
    return this.http.put(url, data);
  }
  delete(url: string): Observable<any> {
    return this.http.delete(url);
  }
}
