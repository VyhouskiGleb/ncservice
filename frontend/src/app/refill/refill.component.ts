import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../providers/user.service";
import {HttpUserService} from "../services/http-user.service";
import {NotificationService} from "../providers/notification.service";

@Component({
  selector: 'app-refill',
  templateUrl: './refill.component.html',
  styleUrls: ['./refill.component.css']
})
export class RefillComponent implements OnInit, OnDestroy {
  refillForm: FormGroup;
  ready: boolean = false;
  cardNumberValue: string ="";
  ownerNameValue: string ="";
  dateValueValue: string ="";
  ba: any;

  sub:any;
  constructor(private userService: UserService, private http: HttpUserService, private notification: NotificationService) {}
  ngOnInit() {
    this.formInitial();
    this.onDataLoad();
  }

  onDataLoad() {
    this.sub = this.http.getCurrentBillingAccount().subscribe((data) => {
      this.ready = data.status;
      this.ba = data.billing;
      let tmp = data.billing.credit.split("|");
      this.cardNumberValue = tmp[0];
      this.ownerNameValue = tmp[1];
      this.dateValueValue = tmp[2];

      if(this.ready) this.formInitial();
    })
  }

  formInitial() {
    this.refillForm = new FormGroup({

      "cardNumber": new FormControl(this.cardNumberValue, [Validators.required, Validators.pattern(/^[0-9]*$/),
        Validators.minLength(16), Validators.maxLength(16)]),
      "ownerName": new FormControl(this.ownerNameValue, [
        Validators.required,
      ]),
      "moneyValue": new FormControl(null, [Validators.required, Validators.pattern(/^[0-9]*$/)]),
      "dateValue": new FormControl(this.dateValueValue, [Validators.required, Validators.pattern(/^[\/0-9]*$/)])
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  submit() {
    this.ba.credit = this.refillForm.value.cardNumber +"|"+this.refillForm.value.ownerName+"|"+this.refillForm.value.dateValue;
    this.http.updateBillingAccount(this.ba, this.refillForm.value.moneyValue).subscribe((data) =>{
      this.ba = data.billing;
      this.notification.setNotification({
        id: null,
        title: data.message,
        status: true
      });
    },
      (err) => {
        this.notification.setNotification({
          id: null,
          title: "Refill error",
          status: false
        });
      })

  }

}
