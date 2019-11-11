import {Component, Input, SimpleChanges, OnChanges} from '@angular/core';

@Component({
  selector: 'app-preloader-small',
  templateUrl: './preloader-small.component.html',
  styleUrls: ['./preloader-small.component.css']
})
export class PreloaderSmallComponent implements OnChanges {
  @Input() status ?= false;
  ngOnChanges(changes: SimpleChanges) {
    this.status = changes.status.currentValue;
  }
}
