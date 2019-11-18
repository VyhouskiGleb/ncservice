import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admincontrols',
  templateUrl: './admincontrols.component.html',
  styleUrls: ['./admincontrols.component.css']
})
export class AdmincontrolsComponent implements OnInit {

  state:number = 1;


  constructor() { }

  ngOnInit() {
  }

  handleClickTab = (tabId: number): void => {
    this.state = tabId;
  }

}
