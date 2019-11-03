import { Injectable } from '@angular/core';
import {Movie} from '../interfaces/movie';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {HttpClientService} from './http-client.service';
declare var require: any;
const hl = require('../document.json');

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  private movieArray: Movie[];
  private moviesList = hl.content;

  constructor(private shttp: HttpClientService) {}
  getList(end: number, search: string): Observable<Movie[]> {
    return this.shttp.get('http://localhost:8006/api/get-movies?end=' + end + '&search=' + search).pipe(map((data) => {
      console.log(data);
      return data;
    }));
  }
  getCounter(): Observable<any> {
    return this.shttp.get('http://localhost:8006/api/get-movies/get-counter').pipe(map((data) => {
      console.log(data);
      return data;
    }));
  }
  getSearchData(searchString: string): Observable<Movie[]> {
    return this.shttp.get('http://localhost:8006/api/get-movies/search?string=' + searchString).pipe(map((data) => {
      console.log(data);
      return data;
    }));
  }

}
