import {Component, Input, OnInit} from '@angular/core';

const animationIn: string = "scale-in-tr";
const animationOut: string = "scale-out-tr";

@Component({
  selector: 'app-image-modal',
  templateUrl: './image-modal.component.html',
  styleUrls: ['./image-modal.component.css']
})
export class ImageModalComponent implements OnInit {

  open: boolean = false;
  animation: string = animationIn;

  handleModalOpen = (event):void => {
    if(this.open === false) {
      this.animation = animationIn;
      this.open = true;
    }
    else if(this.open === true) {
      this.animation = animationOut;
      setTimeout(()=> this.open = false, 150)
    }
  };

  constructor() { }

  ngOnInit() {
  }

}
