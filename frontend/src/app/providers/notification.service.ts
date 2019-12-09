import {Injectable} from '@angular/core';
import {Subject, Observable} from 'rxjs';


interface Notification {
  id: number,
  title: string,
  status : boolean
}

@Injectable()
export class NotificationService{
  notification: Notification[] =  [];
  observable = new Subject<any>();
  constructor() {
    this.observable.next(this.notification)
  }

  public setNotification = (param :Notification): void => {
    this.notification.push(param);
    this.observable.next(this.notification);
    setTimeout(() => {
      this.notification.splice(0,1);
      this.observable.next(this.notification);
    }, 2500);
  };

  public getNotification = () => {
    return this.observable;
  };

}
