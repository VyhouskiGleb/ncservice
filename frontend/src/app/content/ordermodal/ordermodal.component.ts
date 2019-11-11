import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {MoviesService} from "../../services/movies.service";

@Component({
  selector: 'app-ordermodal',
  templateUrl: './ordermodal.component.html',
  styleUrls: ['./ordermodal.component.css']
})
export class OrdermodalComponent implements OnInit {

  @Input() modalItem: any;
  @Output() confirmEvent: EventEmitter<boolean> = new EventEmitter<boolean>();

  handleConfirmEvent(): void {
    this.confirmEvent.emit(false);
  }
  handleAccept() : void {
    console.log('Accept');
  }
  constructor(private service :MoviesService) {}

  ngOnInit() {
  }

}
