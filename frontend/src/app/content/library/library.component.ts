import { Component, OnInit } from '@angular/core';
import {MoviesService} from '../../services/movies.service';
import {Movie} from '../../interfaces/movie';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  libData = [];

  constructor(private moviesService: MoviesService) { }

  ngOnInit() {
    this.moviesService.getLib().subscribe(data => this.libData = data)
  }

}
