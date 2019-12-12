import { Component, OnInit } from '@angular/core';
import {UserService} from "../providers/user.service";
import {AuthService} from "../providers/auth.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  onLogOut = (event) => {
    event.preventDefault();
    this.authService.logOut();
  }

}
