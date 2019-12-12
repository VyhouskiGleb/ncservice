import {Component, Input, OnChanges, OnInit, OnDestroy, SimpleChanges} from '@angular/core';
import {MoviesService} from '../../services/movies.service';
import {Movie} from '../../interfaces/movie';

@Component({
  selector: 'app-hirelist',
  templateUrl: './hirelist.component.html',
  styleUrls: ['./hirelist.component.css']
})

export class HirelistComponent implements OnInit, OnChanges, OnDestroy {
  @Input() page: number;
  // tslint:disable-next-line: no-output-on-prefix
  movies: Movie[];
  perPage = 9;
  itemsCounter = 0;
  activePageEvent = true;
  searchString = '';
  sub: any;
  count: any;

  constructor(private moviesService: MoviesService) { }
  ngOnInit() {
    this.sub = this.moviesService.getList(this.page * this.perPage, this.searchString).subscribe((data:any) => {
      this.activePageEvent = false;
      this.movies = data.movies;
      this.itemsCounter = data.counter;
    });
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  pageIncrement() {
    this.activePageEvent = true;
    this.sub = this.moviesService.getList(this.page * this.perPage, this.searchString).subscribe(
      (data: any) => {
        this.movies = data.movies;
        this.activePageEvent = false;
        this.itemsCounter = data.counter;
    });
  }

  searchEvent(event: any) {
    this.searchString = event;
    if (event.length === 0) {
      this.pageIncrement();
    } else {
      this.activePageEvent = true;
      this.sub = this.moviesService.getSearchData(this.searchString).subscribe(
        (data: any) => {
          this.movies = data.movies;
          this.activePageEvent = false;
      });
    }
  }
  ngOnChanges(changes: SimpleChanges) {
    if (changes.page.previousValue !== changes.page.currentValue) {
      if(Math.ceil(this.itemsCounter / this.perPage) >= changes.page.currentValue) {
        this.page = changes.page.currentValue;
        setTimeout(() => this.pageIncrement(), 500);
      }
    }
  }
}
