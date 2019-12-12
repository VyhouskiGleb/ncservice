import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../providers/auth.service";
import {HttpUserService} from "../services/http-user.service";
import {NotificationService} from "../providers/notification.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  constructor(private router: Router, private authService: AuthService, private http: HttpUserService, private notification: NotificationService) {}

  ngOnInit() {
    this.registerForm = new FormGroup({
      userLogin: new FormControl('', Validators.required),
      userPassword: new FormControl('', Validators.required),
    });
  }
  submit() {
    this.http.tryLogin(this.registerForm.value.userLogin, this.registerForm.value.userPassword).subscribe((data) =>{
        this.authService.set(data.token, data.username);
        this.notification.setNotification({
          id: null,
          title: "Welcome " + data.username,
          status: true
        });
        this.router.navigate(['/']);

      },
      (err) => {
        this.notification.setNotification({
          id: null,
          title: "Invalid username or password",
          status: false
        })
      });
  }

}
