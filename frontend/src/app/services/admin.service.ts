import { Injectable } from '@angular/core';
import {Movie} from '../interfaces/movie';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {HttpClientService} from './http-client.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private movieArray: Movie[];

  constructor(private shttp: HttpClientService) {}
  getList(end: number, search: string): Observable<Movie[]> {
    return this.shttp.get('http://localhost:3808/api/movies/get-all?end=' + end + '&search=' + search).pipe(map((data) => {
      console.log(data);
      return data;
    }));
  }

}
