import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {MoviesService} from "../../services/movies.service";
import {NotificationService} from "../../providers/notification.service";
import {UserService} from "../../providers/user.service";

// @ts-ignore

@Component({
  selector: 'app-moviecard',
  templateUrl: './moviecard.component.html',
  styleUrls: ['./moviecard.component.css']
})
export class MoviecardComponent implements OnInit, OnDestroy {

  @Input() item: any;
  shortDescription: string;
  fullDescription: string;
  showHider = false;
  hiderStatus = false;
  fullWidget = false;
  subscribed = false;
  subscription: any = null;
  utcEnd = 0;
  timer: any;
  sub: any;
  constructor(private http: MoviesService, private notification: NotificationService, private userService: UserService) { }

  ngOnInit() {
    this.shortDescription = this.item.description.substr(0, 100);
    if (this.item.description.length > 100) {
      this.shortDescription += '...';
      this.showHider = true;
    }
    this.fullDescription = this.item.description;
    if(this.userService.getDefaultUser() !== undefined) this.checkUser(this.userService.getDefaultUser());
    this.sub = this.userService.userSub().subscribe((data) => {
      this.checkUser(data);
    })
  }
  checkUser(user) {
    if(this.timer !== undefined) {
      clearInterval(this.timer);
    }

    let subs = user.subscriptions;
    subs.find((res) => {
      if(res.movie.id === this.item.id && res.status === "active") {
        this.subscribed = true;
        this.subscription = res;
        let tmpDate = new Date();
        this.utcEnd = res.utcEnd - tmpDate.getTime();
        this.timer = setInterval(() => {
          if(res.utcEnd - tmpDate.getTime() > 0) {
            let tmpDate = new Date();
            this.utcEnd = res.utcEnd - tmpDate.getTime();
          }else {
            clearInterval(this.timer);
          }
        }, 1000)
      }else if(res.movie.id === this.item.id && res.status === "finished") {
        this.subscribed = false;
        this.subscription = null;
      }
    });
  }

  handleUnsubscribe() {
    if(this.subscribed) {
      this.subscription.status = "finished";
      this.http.unsubscribe(this.subscription.id, this.subscription).subscribe(
        (data)=>{
          this.notification.setNotification({
            id: null,
            title: data.message,
            status: data.status
          });
          if(data.status == true) {
            this.subscription = null;
            this.subscribed = false;
          }
        }
      )
    }
  }

  handleShowHide(event: any, value: boolean): void {
    event.preventDefault();
    this.hiderStatus = value;
  }
  handleWidget = (value: boolean): void => {
    this.fullWidget = value;
  };
  handleClick = (): void => {
    this.fullWidget = true;
  };
  handleConfirm = (): void => {
    this.http.addToLib(this.item).subscribe((data) => {
      this.notification.setNotification({
        id: null,
        title: data.message,
        status: data.status
      });
    });
  };

  getYoutubeLikeToDisplay(millisec:number) {
    let seconds:string = (millisec / 1000).toFixed(0);
    let minutes:string = Math.floor(parseInt(seconds) / 60).toString();
    let hours = "";
    if (parseInt(minutes) > 59) {
      hours = Math.floor(parseInt(minutes) / 60).toString();
      hours = (parseInt(hours) >= 10) ? hours : "0" + hours;
      minutes = (parseInt(minutes) - (parseInt(hours) * 60)).toString();
      minutes = (parseInt(minutes) >= 10) ? minutes : "0" + minutes;
    }
    seconds = Math.floor(parseInt(seconds) % 60).toString();
    seconds = (parseInt(seconds) >= 10) ? seconds : "0" + seconds;
    if (hours != "") {
      return hours + ":" + minutes + ":" + seconds;
    }
    return minutes + ":" + seconds;
  }
  ngOnDestroy() {
    clearInterval(this.timer);
    this.sub.unsubscribe();
  }

}
