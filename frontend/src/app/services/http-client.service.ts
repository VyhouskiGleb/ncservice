import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {tap} from "rxjs/operators";
import {UserService} from "../providers/user.service";

@Injectable({
  providedIn: 'root'

})
export class HttpClientService {

  constructor(private  http: HttpClient) { }

  post(url: string, data: any) {
    return this.http.post(url, data);
  }
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
