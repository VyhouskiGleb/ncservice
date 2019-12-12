import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {MoviesService} from '../../services/movies.service';
import {Lib} from "../../interfaces/lib";
import lodash from 'lodash';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit, OnDestroy, OnChanges {
  @Input() page: number;

  lib: any = {
    data: []
  };
  activePageEvent = true;
  searchString = '';
  sub: any;
  timer: any;
  perPage = 9;
  itemsCounter = 0;
  count: any;
  constructor(private moviesService: MoviesService) { }

  ngOnInit() {
    this.pageIncrement();
    this.timer  = setInterval(()=>this.loadData(), 1000)
  }

  pageIncrement() {
    this.activePageEvent = true;
    this.loadData()
  }

  loadData = () => {
    this.sub = this.moviesService.getLibWithStatus(0, this.page * this.perPage, "active").subscribe((data: any) => {
      if(lodash.isEqual(data, this.lib) == false) {
        this.lib = data;
        this.activePageEvent = false;
        this.itemsCounter = data.counter;
      }
    });
  };

  ngOnChanges(changes: SimpleChanges) {
    if (changes.page.previousValue !== changes.page.currentValue) {
      if(Math.ceil(this.itemsCounter / this.perPage) >= changes.page.currentValue) {
        this.page = changes.page.currentValue;
        setTimeout(() => this.pageIncrement(), 500);
      } else {
        this.activePageEvent = false;
      }
    }
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
