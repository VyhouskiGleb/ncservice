import {Injectable} from '@angular/core';
// @ts-ignore
import {User} from "../interfaces/user";
import {Observable, Subject} from "rxjs";
import {Router} from '@angular/router';
import {HttpUserService} from "../services/http-user.service";
import {NotificationService} from "./notification.service";
import lodash from 'lodash';

@Injectable({
  providedIn: 'root'
})
export class UserService{
  userInfo;
  userToken: string = localStorage.getItem("token");
  userName: string = localStorage.getItem("username");
  userInfoObs = new Subject<User>();
  timer;


  constructor(private router: Router, private http: HttpUserService, private notification: NotificationService) {
    if(this.userInfo !== undefined) this.userInfoObs.next(this.userInfo);
    this.timer = this.startListen();
  }

  startListen = () => {
    this.getUserInfo();
    return setInterval(() => {
      this.getUserInfo();
    },1100)
  };

  getDefaultUser(){
    return this.userInfo;
  };

  principalUpdate() {
    this.getUserInfo();
  }

  userSub() :Subject<User> {
    return this.userInfoObs;
  }

  getUserInfo() {
    if(localStorage.getItem("username") !== null) {
      const subs = this.http.getUser(localStorage.getItem("username")).subscribe((data) => {
          if(lodash.isEqual(data, this.userInfo) == false) {
            this.userInfo = data;
            this.userInfoObs.next(data);
            subs.unsubscribe();
          }
        },
        (err) => {
          console.log("Auth error");
        }
      );
    }
  }



}
