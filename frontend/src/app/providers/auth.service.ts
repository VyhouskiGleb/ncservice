import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token: string = null;

  updateToken() {
    this.token = localStorage.getItem("token");
  }

  get(): string {
    this.updateToken();
    return this.token
  }

  set(token:string, username: string): string {
    localStorage.setItem("token", token);
    localStorage.setItem("username", username);
    this.updateToken();
    return this.token;
  }

  isAuth():boolean {
    this.updateToken();
    return !(this.token === null || this.token === "");
  }

  logOut = ():void => {
    this.token = null;
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    this.router.navigate(['/login']);
  };

  constructor(private router: Router) {
    this.updateToken();
  }


}
