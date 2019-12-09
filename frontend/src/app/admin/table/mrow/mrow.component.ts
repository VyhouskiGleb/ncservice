import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Movie} from "../../../interfaces/movie";
import {AdminService} from "../../../services/admin.service";
import {NotificationService} from "../../../providers/notification.service";

@Component({
  selector: 'app-mrow',
  templateUrl: './mrow.component.html',
  styleUrls: ['./mrow.component.css']
})
export class MrowComponent implements OnInit {
  @Input() item: Movie;
  load:boolean = false;
  status: boolean = true;
  removed: boolean = false;
  timeOut :any;
  @Output() onUpdateData: EventEmitter<string> = new EventEmitter<string>();

  constructor(private adminService: AdminService, private notificationService: NotificationService ) { }

  ngOnInit() {

  }

  onDeleteRow = (event: any): void => {
    event.target.value;
    this.load = true;
    /*this.adminService.deleteRow(this.item.id).subscribe((data)=>{
        this.load = false;
        this.status = data;
      },
      (err) => {
        this.load = false;
        this.status = false
      });*/
    let notificationAlarmMsg = {
      id: null,
      title: "Successful removed: #" + this.item.id,
      status: true
    };
    if(this.status === false) {
      notificationAlarmMsg = {
        id: null,
        title: "Fail removed: #" + this.item.id,
        status: false
      }
    }
    this.notificationService.setNotification(notificationAlarmMsg);
    this.onUpdateData.emit();
  };

  onDataChange = (event: any, data: string) => {
    this.item[data] = event.target.value;
    this.load = true;
    if(this.timeOut !== undefined) clearTimeout(this.timeOut);
    this.timeOut = setTimeout(() =>
    this.adminService.updateRow(this.item).subscribe((data)=>{
      this.load = false;
      this.removed = data;
    },
    (err) => {
      this.load = false;
      this.status = false;
      this.removed = false
    },
    ), 500);
  }
}
