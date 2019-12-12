import {HttpEvent, HttpEventType, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {UserService} from "../providers/user.service";
import {AuthService} from "../providers/auth.service";

@Injectable({
  providedIn: 'root'
})
export class InterceptService implements HttpInterceptor{

  constructor(private  authService: AuthService) { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(this.authService.isAuth()) {
      request = request.clone({
        setHeaders: {
          Authorization:  this.authService.get()
        }
      });
    }
    return next.handle(request).pipe(
      tap(
        event => {},
        (err) => {
          if(err.status === 401 || err.status === 403 || err.status === 500) {
            this.authService.logOut();
          }
        })
    );
  }
}
