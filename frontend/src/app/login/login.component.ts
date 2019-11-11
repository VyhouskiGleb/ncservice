import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  constructor() {
    this.loginForm = new FormGroup({
      userLogin: new FormControl('', Validators.required),
      userPassword: new FormControl('', Validators.required),
  });
  }

  ngOnInit() {
    console.log(this.loginForm);
  }
  submit() {
    console.log(this.loginForm);
  }

}
