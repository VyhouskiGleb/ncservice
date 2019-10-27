import { Injectable } from '@angular/core';
declare var require: any;
const hl = require('../document.json');

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  private moviesList = hl.content;
  private stat = 1;
  constructor() {}
  getList() {
    return this.moviesList;
  }
}
