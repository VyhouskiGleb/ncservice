import { Component, OnInit, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import {MoviesService} from '../../services/movies.service';

@Component({
  selector: 'app-hirelist',
  templateUrl: './hirelist.component.html',
  styleUrls: ['./hirelist.component.css']
})
export class HirelistComponent implements OnInit, AfterViewInit{
  @ViewChild('autoload', {static : false}) autoloadBox: any;
  movies: any;
  yTriggerCoords = 0;

  constructor(private moviesService: MoviesService) {
    console.log(window);
  }

  ngAfterViewInit() {
    this.yTriggerCoords = this.autoloadBox.nativeElement.offsetTop + this.autoloadBox.nativeElement.offsetHeight;
    console.log(window.pageYOffset);
    console.log(this.yTriggerCoords);
    const conatiner = document.getElementById('scroll_container');
    conatiner.onscroll = (event) => {
      console.log(conatiner.scrollHeight);
      // console.log(event);
      console.log('body scrolled');
    };
  }
  ngOnInit() {
    this.movies = this.moviesService.getList();
  }
  searchEvent(event: any) {
    console.log(event);
  }

}
