import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }   from '@angular/forms';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { ContentComponent } from './content/content.component';
import { LibraryComponent } from './content/library/library.component';
import { HirelistComponent } from './content/hirelist/hirelist.component';
import { MoviecardComponent } from './content/moviecard/moviecard.component';
import { BtnComponent } from './common/btn/btn.component';
import { SearchfldComponent } from './common/searchfld/searchfld.component';
import { FormsModule } from '@angular/forms';
import { HistoryComponent } from './history/history.component';
import { MovecardmodalComponent } from './content/hirelist/movecardmodal/movecardmodal.component';
import { TabsDirective } from './common/tabs.directive';
import { YoutubeComponent } from './common/youtube/youtube.component';

import { MoviesService } from './services/movies.service';
import { PreloaderSmallComponent } from './common/preloader-small/preloader-small.component';
import { OrdermodalComponent } from './content/ordermodal/ordermodal.component';
import { AdmincontrolsComponent } from './admin/admincontrols/admincontrols.component';
import { MoviesEditorComponent } from './admin/movies-editor/movies-editor.component';
import { UsersEditorComponent } from './admin/users-editor/users-editor.component';
import { TableComponent } from './admin/table/table.component';
import { MrowComponent } from './admin/table/mrow/mrow.component';
import { ActionMessageComponent } from './common/action-message/action-message.component';
import { ImageModalComponent } from './admin/table/image-modal/image-modal.component';
import { ModalComponent } from './common/modal/modal.component';

import {NotificationService} from "./providers/notification.service";
import { NotificationOutletComponent } from './common/notification-outlet/notification-outlet.component';
import {UserService} from "./providers/user.service";
import { UserDetailsComponent } from './common/user-details/user-details.component';
import {InterceptService} from "./services/intercept.service";
import { UserGuard }   from './user.guard';
import {AuthService} from "./providers/auth.service";
import { RefillComponent } from './refill/refill.component';
import { RegisterComponent } from './register/register.component';
const appRoutes: Routes = [
  { path: '', component: MainComponent, data: {type: 'app'}, canActivate: [UserGuard]},
  { path: 'login', component: LoginComponent, data: {type: 'public'} },
  { path: 'register', component: RegisterComponent, data: {type: 'public'} },
  { path: 'history', component: HistoryComponent, data: {type: 'app'}, canActivate: [UserGuard] },
  { path: 'admin', component: AdmincontrolsComponent, data: {type: 'app'}, canActivate: [UserGuard] },
  { path: 'refill', component: RefillComponent, data: {type: 'app'}, canActivate: [UserGuard] },
  { path: '**', component: AppComponent, data: {type: 'app'} }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    MainComponent,
    LoginComponent,
    ContentComponent,
    LibraryComponent,
    HirelistComponent,
    MoviecardComponent,
    BtnComponent,
    SearchfldComponent,
    HistoryComponent,
    MovecardmodalComponent,
    TabsDirective,
    YoutubeComponent,
    PreloaderSmallComponent,
    OrdermodalComponent,
    AdmincontrolsComponent,
    MoviesEditorComponent,
    UsersEditorComponent,
    TableComponent,
    MrowComponent,
    ActionMessageComponent,
    ImageModalComponent,
    NotificationOutletComponent,
    UserDetailsComponent,
    RefillComponent,
    ModalComponent,
    RegisterComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    ),
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    MoviesService,
    NotificationService,
    UserGuard,
    UserService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptService,
      multi: true
    }
  ], // service.ts вспомогательные сущности (прописываем свои компоненты)
  bootstrap: [AppComponent]
})
export class AppModule { }
