import { Component, OnInit } from '@angular/core';
import {NotificationService} from "../../providers/notification.service";

interface Notification {
  id: number,
  title: string,
  status : boolean
}

@Component({
  selector: 'app-notification-outlet',
  templateUrl: './notification-outlet.component.html',
  styleUrls: ['./notification-outlet.component.css']
})
export class NotificationOutletComponent implements OnInit {

  notification: Notification[] = [];

  constructor(private notificationService: NotificationService) {}
  ngOnInit() {
    this.notificationService.getNotification().subscribe((data) => this.notification = data)
  }

}
