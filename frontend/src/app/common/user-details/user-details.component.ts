import { Component, OnInit } from '@angular/core';
import {UserService} from "../../providers/user.service";

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user: any;

  constructor(private userService: UserService ) {}

  ngOnInit() {
    this.user = this.userService.getDefaultUser();
    this.userService.userSub().subscribe((data)=>{
      this.user = data;
    })
  }

}
