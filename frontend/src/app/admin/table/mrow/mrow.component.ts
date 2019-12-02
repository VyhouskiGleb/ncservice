import { Component, OnInit, Input } from '@angular/core';
import {Movie} from "../../../interfaces/movie";
import {AdminService} from "../../../services/admin.service";

@Component({
  selector: 'app-mrow',
  templateUrl: './mrow.component.html',
  styleUrls: ['./mrow.component.css']
})
export class MrowComponent implements OnInit {
  @Input() item: Movie;
  load:boolean = false;
  status: boolean = true;
  removed: boolean = false;
  constructor(private adminService: AdminService ) { }

  ngOnInit() {
  }

  onDeleteRow = (event: any): void => {
    event.target.value;
    this.load = true;
    this.adminService.deleteRow(this.item.id).subscribe((data)=>{
        this.load = false;
        this.status = data;
        console.log(data);
      },
      (err) => {
        this.load = false;
        this.status = false
        console.log(err);
      });
  };

  onDataChange = (event: any, data: string) => {
    this.item[data] = event.target.value;
    this.load = true;
    this.adminService.updateRow(this.item).subscribe((data)=>{
      this.load = false;
      this.removed = data;
    },
    (err) => {
      this.load = false;
      this.removed = false
    },
    )
  }
}
