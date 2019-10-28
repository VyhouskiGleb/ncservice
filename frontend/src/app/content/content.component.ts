import {Component, OnInit, AfterViewInit, ElementRef} from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})

export class ContentComponent implements OnInit, AfterViewInit {
  loadingStatus = false;
  tabstate = 1;
  hlBtnActivity = true;
  LibBtnActivity = false;

  loadingStatusCoords = {
    scrollHeight : 0,
    scrollCalculation : 0
  };

  controlsHandleChange(currentTabId: number): void {
    this.hlBtnActivity = this.LibBtnActivity = false;
    this.tabstate = currentTabId;
    (this.tabstate === 1) ? this.hlBtnActivity = true : this.LibBtnActivity = true;
  }


  constructor(private host: ElementRef) { }

  ngOnInit() {
  }
  loadEvent(event) {
    console.log(event);
    this.loadingStatus = event;
  }
  ngAfterViewInit(): void {
    this.host.nativeElement.onscroll =  (e) => {
      if (e.target.scrollHeight - e.target.scrollTop < window.innerHeight) {
        this.loadingStatus = true;
      }
    };
  }
}
