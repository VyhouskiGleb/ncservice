import { Injectable } from '@angular/core';
import {Movie} from '../interfaces/movie';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {HttpClientService} from './http-client.service';
import {UserService} from "../providers/user.service";

@Injectable({providedIn: 'root'})
export class MoviesService {

  constructor(private http: HttpClientService, private userService: UserService) {}
  getList(end: number, search: string): Observable<Movie[]> {
    return this.http.get('http://localhost:3808/api/movies/list?page=0&per=' + end).pipe(map((data) => {;
      return data;
    }));
  }
  unsubscribe(id:number, item:any) : Observable<any> {
    return this.http.put('http://localhost:3808/api/lib/' + id, item).pipe(map((data) => {;
      return data;
    }));
  }
  addToLib(item): Observable<any> {
    let user = this.userService.getDefaultUser();
    let tmp = {
      userId: user.id,
      status: "active",
      movie: {
        id: item.id
      }
    };
    console.log(tmp);
    return this.http.post("http://localhost:3808/api/lib",tmp).pipe(map((data) => {
      return data;
    }));
  }
  getSearchData(searchString: string): Observable<Movie[]> {
    return this.http.get('http://localhost:3808/api/movies/search?query=' + searchString).pipe(map((data) => {
      console.log(data);
      return data;
    }));
  }

  getLib(start:number, perPage:number): Observable<any[]> {
    return this.http.get('http://localhost:3808/api/lib/borders?start='+start+"&per="+perPage).pipe(map((data) => {
      return data;
    }));
  }

  getLibWithStatus(start:number, perPage:number, status: string): Observable<any[]> {
    return this.http.get('http://localhost:3808/api/lib/user-lib?start='+start+"&per="+perPage).pipe(map((data) => {
      return data;
    }));
  }


}
