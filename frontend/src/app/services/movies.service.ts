import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClientService} from './http-client.service';
declare var require: any;
const hl = require('../document.json');

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  private moviesList = hl.content;

  constructor(private shttp: HttpClientService) {}
  getList() {
    this.shttp.get('https://jsonplaceholder.typicode.com/users').subscribe(
      (data) => {
        console.log(data);
      }
    );
    return this.moviesList;
  }
}
