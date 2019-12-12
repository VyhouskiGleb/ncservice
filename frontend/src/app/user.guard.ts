import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from "@angular/router";
import {Observable} from "rxjs";
import {UserService} from "./providers/user.service";
import {Injectable} from "@angular/core";
import {AuthService} from "./providers/auth.service";


@Injectable({providedIn: 'root'})
export class UserGuard implements CanActivate{

  constructor(private router: Router, private authService: AuthService) {}

  isAuth():boolean {
    let userToken = localStorage.getItem("token");
    return !(userToken === null || userToken === "");
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean{
    if(this.isAuth() === false) {
      this.router.navigate(['/login']);
    }else {
      return this.isAuth();
    }
  }
}
