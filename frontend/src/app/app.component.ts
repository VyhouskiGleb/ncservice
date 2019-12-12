import {Component} from '@angular/core';
import {UserService} from "./providers/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})

export class AppComponent{
  constructor(private user: UserService) {}
}
