import {Component, Input, Output, OnChanges, OnInit, SimpleChanges, EventEmitter} from '@angular/core';
import {MoviesService} from '../../services/movies.service';

@Component({
  selector: 'app-hirelist',
  templateUrl: './hirelist.component.html',
  styleUrls: ['./hirelist.component.css']
})
export class HirelistComponent implements OnInit, OnChanges {
  @Input() loadingStatus: any;
  // tslint:disable-next-line: no-output-on-prefix
  @Output() onLoadStatus: EventEmitter<string> = new EventEmitter<string>();
  movies: any;
  page = 1;
  perPage = 6;
  activePageEvent = false;

  constructor(private moviesService: MoviesService) { }
  ngOnInit() {
    console.log('Loading Status', this.loadingStatus);
    this.movies = this.moviesService.getList();
  }

  pageIncrement() {
    this.activePageEvent = true;
    this.page ++;
    setTimeout(() => {
      this.loadingStatus = false;
      this.activePageEvent = false;
      this.onLoadStatus.emit(this.loadingStatus);
    }, 1500);
    console.log(this.page * this.perPage);
  }
  searchEvent(event: any) {
    console.log(event);
  }
  ngOnChanges(changes: SimpleChanges) {
    console.log(changes);
    if (changes.loadingStatus.currentValue !== this.loadingStatus && this.activePageEvent === false) {
      this.pageIncrement();
    }
  }

}
