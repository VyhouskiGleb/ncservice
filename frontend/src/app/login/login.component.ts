import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpUserService} from "../services/http-user.service";
import {NotificationService} from "../providers/notification.service";
import {Router} from "@angular/router";
import {AuthService} from "../providers/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  constructor(private router: Router, private authService: AuthService, private http: HttpUserService, private notification: NotificationService) {}

  ngOnInit() {
    this.loginForm = new FormGroup({
      userLogin: new FormControl('', Validators.required),
      userPassword: new FormControl('', Validators.required),
    });
  }
  submit() {
    this.http.tryLogin(this.loginForm.value.userLogin, this.loginForm.value.userPassword).subscribe((data) =>{
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
