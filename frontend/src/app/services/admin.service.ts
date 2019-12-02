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
  getList(currentPage:number, perPage:number,  filter: string ): Observable<{
    counter: number,
    data: Movie[]
  }> {
    return this.shttp.get('http://localhost:3808/api/movies').pipe(map((data) => {
      return {
        counter: data.length,
        data: data.slice(currentPage * perPage, (currentPage+1) * perPage)
      };
    }));
  }
  updateRow(row: Movie): Observable<boolean> {
    return this.shttp.put('http://localhost:3808/api/movies', row)
      .pipe(map((data) => {
      return data;
    }));
  }
  deleteRow( id: number) : Observable<boolean> {
    return this.shttp.delete('http://localhost:3808/api/movies/'+ id)
      .pipe(map((data) => {
        return data;
      }));
  }
  searchList(currentPage:number, perPage:number,  filter: string , query: string): Observable<{
      counter: number,
      data: Movie[]
    }> {
    return this.shttp.get('http://localhost:3808/api/movies/search?query='+query).pipe(map((data) => {
      return {
        counter: data.length,
        data: data.slice(currentPage * perPage, (currentPage+1) * perPage)
      };
    }));
  }
}
