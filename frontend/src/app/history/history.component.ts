import {Component, OnInit} from '@angular/core';
import {Movie} from "../interfaces/movie";
import {MoviesService} from "../services/movies.service";
import {Lib} from "../interfaces/lib";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  libArray: any = {
    counter: 0,
    data: []
  };

  sub:any;
  perPage = 10;
  currentPage = 0;

  constructor(private movieService: MoviesService) { }

  ngOnInit() {
    this.onDataLoad();
  }

  onChangeCurrentPage = (event,val): void => {
    event.preventDefault();
    this.currentPage = val;
    this.onDataLoad();
  };

  onDataLoad = (): void => {
    let DataEventer = (data) => {
      this.libArray.data = data.data;
      this.libArray.counter = data.counter;
    };
    this.movieService.getLib(this.currentPage * this.perPage, this.perPage).subscribe(
      (data) => {
        DataEventer(data);
        },
    );
  };
  generatePaginationArray = (value): number[] => {
    let tmpArray = [];

    for(let i = 0; i < Math.ceil(value / this.perPage); i++) {
      tmpArray.push(i+1);
    }
    return tmpArray;
  };


}
