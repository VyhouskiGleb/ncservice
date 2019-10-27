import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-movecardmodal',
  templateUrl: './movecardmodal.component.html',
  styleUrls: ['./movecardmodal.component.css']
})
export class MovecardmodalComponent implements OnInit {

  @Input() modalItem: any;
  // tslint:disable-next-line: no-output-on-prefix
  @Output() modalEvent: EventEmitter<boolean> = new EventEmitter<boolean>();

  handleModalCloseEvent(): void {
    this.modalEvent.emit(false);
  }

  constructor() { }

  ngOnInit() {
  }

}
