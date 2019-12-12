import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {HttpClientService} from './http-client.service';

@Injectable({
  providedIn: 'root'
})
export class HttpUserService {

  constructor(private http: HttpClientService) {}

  tryLogin(login: string, password: string): Observable<any> {
    return this.http.post("http://localhost:3808/token/generate-token", {
      username: login,
      password: password
    }).pipe(map((data) => {
      console.log(data);
      return data;
    }));
  }

  getUser(login: string): Observable<any> {
    return this.http.get("http://localhost:3808/api/user/login/" + login).pipe(map((data) => {
      return data
    }));
  }

  getCurrentBillingAccount(): Observable<any> {
    return this.http.get("http://localhost:3808/api/ba/user").pipe(map((data) => {
      return data
    }));
  }

  updateBillingAccount(ba:any, money: number = 0): Observable<any> {
    return this.http.put("http://localhost:3808/api/ba/?money="+money, ba ).pipe(map((data) => {
      return data
    }));
  }

}
