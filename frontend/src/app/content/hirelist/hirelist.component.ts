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
    this.sub = this.moviesService.getList(this.page * this.perPage, this.searchString).subscribe((data: Movie[]) => {
      this.activePageEvent = false;
      this.movies = data
    });
    this.count = this.moviesService.getCounter().subscribe((data: {counter: number}) => this.itemsCounter = data.counter);
  }



  ngOnDestroy() {
    this.sub.unsubscribe();
    this.count.unsubscribe();
  }

  pageIncrement() {
    this.activePageEvent = true;
    this.sub = this.moviesService.getList(this.page * this.perPage, this.searchString).subscribe(
      (data: Movie[]) => {
        this.movies = data;
        this.activePageEvent = false;
    });
  }

  searchEvent(event: any) {
    this.searchString = event;
    if (event.length === 0) {
      this.pageIncrement();
    } else {
      this.activePageEvent = true;
      this.sub = this.moviesService.getSearchData(this.searchString).subscribe(
        (data: Movie[]) => {
          this.movies = data;
          this.activePageEvent = false;
      });
    }
  }
  ngOnChanges(changes: SimpleChanges) {
    if (changes.page.previousValue !== changes.page.currentValue
      && Math.ceil(this.itemsCounter / this.perPage) >= changes.page.currentValue) {
      this.page = changes.page.currentValue;
      this.pageIncrement();
    }
  }

}
