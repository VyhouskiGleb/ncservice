import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../services/admin.service";
import {Movie} from "../../interfaces/movie";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  query = "";
  tableData: {
    counter: number,
    data: Movie[]
  } = {
    counter: 0,
    data: []
  };
  perPage = 10;
  currentPage = 0;
  updateNow: boolean = false;



  onInputSearch = (event): void => {
    this.query = event.target.value;
    this.setDefault();
    this.onDataLoad();
  };

  onSelectChange = (event): void => {
    this.perPage = event.target.value;
    this.setDefault();
    this.onDataLoad();
  };

  onChangeCurrentPage = (event,val): void => {
    event.preventDefault();
    this.currentPage = val;
    this.onDataLoad();
  };

  constructor(private adminService: AdminService) { }

  onDataLoad = (): void => {
    let DataEventer = (data) => {
      this.tableData.data = data.data;
      this.tableData.counter = data.counter;
    };
    this.adminService.getList(this.currentPage, this.perPage,"none", this.query).subscribe(
      (data) => {DataEventer(data);},
      );
  };

  ngOnInit(): void {
    this.onDataLoad();
  }

  generatePaginationArray = (value): number[] => {
    let tmpArray = [];
    for(let i = 0; i < Math.ceil(value / this.perPage); i++) {
      tmpArray.push(i+1);
    }
    return tmpArray;
  };

  setDefault = (): void => {
    this.currentPage = 0;
  }

}
