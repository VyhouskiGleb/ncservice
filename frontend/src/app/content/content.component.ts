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
  globalPage = 1;

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
      const childNodes = this.host.nativeElement.childNodes;
      let counter = 0;
      // tslint:disable-next-line: prefer-for-of
      for ( let i = 0; i < childNodes.length; i++) {
        const height = childNodes[i].offsetHeight;
        if (!isNaN(height)) { counter += height; }
      }
      const position = e.target.scrollTop + this.host.nativeElement.offsetHeight;
      if (position >= counter) {
        this.globalPage++;
        console.log(this.globalPage);
        this.loadingStatus = true;
      } else  {
        console.log(this.globalPage);
      }
    };
  }
}
