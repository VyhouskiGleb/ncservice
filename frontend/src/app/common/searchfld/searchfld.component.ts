import { Component, OnInit, SimpleChange, OnChanges, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-searchfld',
  templateUrl: './searchfld.component.html',
  styleUrls: ['./searchfld.component.css']
})
export class SearchfldComponent implements OnInit {

  @Input() sarchString ?= '';
  // tslint:disable-next-line: no-output-on-prefix
  @Output() onChangeSearchString: EventEmitter<string> = new EventEmitter<string>();


  constructor() {
  }

  ngOnInit() {
  }

  handleChangeValue(event: any): void {
    this.sarchString = event.target.value;
    this.onChangeSearchString.emit(this.sarchString);
  }

}
