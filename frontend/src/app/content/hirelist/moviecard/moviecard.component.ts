import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-moviecard',
  templateUrl: './moviecard.component.html',
  styleUrls: ['./moviecard.component.css']
})
export class MoviecardComponent implements OnInit {

  @Input() item: any;
  shortDescription: string;
  fullDescription: string;
  showhidder = false;
  hidderstatus = false;
  fullWidjet = false;
  confirmWidjet = false;
  constructor() { }

  ngOnInit() {
    this.shortDescription = this.item.description.substr(0, 100);
    if (this.item.description.length > 100) {
      this.shortDescription += '...';
      this.showhidder = true;
    }
    this.fullDescription = this.item.description;
  }

  handleShowHide(event: any, value: boolean): void {
    event.preventDefault();
    this.hidderstatus = value;
  }
  handleWidjet = (value: boolean): void => {
    this.fullWidjet = value;
  }
  confirmEvent = (value: boolean): void => {
    this.confirmWidjet = value
  }
  handleClick = (): void => {
    this.fullWidjet = true;
  }
  handleConfirm = (): void => {
    this.confirmWidjet = true;
  }


}
