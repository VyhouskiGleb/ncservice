import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})

export class ContentComponent implements OnInit {

  tabstate = 1;
  hlBtnActivity = true;
  LibBtnActivity = false;

  controlsHandleChange(currentTabId: number): void {
    this.hlBtnActivity = this.LibBtnActivity = false;
    this.tabstate = currentTabId;
    (!this.tabstate) ? this.hlBtnActivity = true : this.LibBtnActivity = true;
  }


  constructor() { }

  ngOnInit() {
  }

}
