import {Component, Input, OnInit, OnChanges, SimpleChange } from '@angular/core';

@Component({
  selector: 'app-btn',
  templateUrl: './btn.component.html',
  styleUrls: ['./btn.component.css']
})
export class BtnComponent implements OnInit, OnChanges  {
  @Input() btntitle ?= 'Default';
  @Input() width ?= 'auto';
  @Input() height ?= '35px';
  @Input() background ?= '#4527A0';
  @Input() hoverBackground ?= '#140078';
  @Input() fontColor ?= '#EEEEEE';
  @Input() fontHoverColor ?= '#EEEEEE';
  @Input() icon ?: any = false;
  @Input() active ?: any = null;

  instyle: any = {};
  iconStyle: any = {};

  tmpBackground = this.background;
  tmpHoverBackground = this.hoverBackground;


  buffer: any = this.instyle;

  handleHover = (): void => {
    this.instyle = {
      ...this.buffer,
      background: this.hoverBackground,
      color: this.fontHoverColor
    };
  }
  handleOver = (): void => {
    this.instyle = this.buffer;
  }

  btnAutoStyle = (): void => {
    if (this.active === true) {
      const tmp: string = this.background;
      this.background = this.hoverBackground;
      this.hoverBackground = tmp;
    } else if (this.active !== null) {
      const tmp: string = this.tmpBackground;
      this.background = this.tmpHoverBackground;
      this.hoverBackground = tmp;
    }
    this.instyle = {
      ...this.instyle,
      width: this.width,
      height: this.height,
      background: this.background,
      color: this.fontColor,
      fontSize: (parseFloat(this.height) - 1) / 2 + 'px'
    };
    this.iconStyle = {
      fontSize: (parseFloat(this.height) ) / 1.7 + 'px'
    };
    this.buffer = this.instyle;
  }

  ngOnChanges(changes: { [property: string]: SimpleChange}) {
    if (changes.active !== undefined) {
      this.active = changes.active.currentValue; this.btnAutoStyle();
    }
  }
  constructor() {
  }

  ngOnInit() {
    this.btnAutoStyle();
  }
}
