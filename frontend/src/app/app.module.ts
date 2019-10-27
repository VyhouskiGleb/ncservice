import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { ContentComponent } from './content/content.component';
import { LibraryComponent } from './content/library/library.component';
import { HirelistComponent } from './content/hirelist/hirelist.component';
import { MoviecardComponent } from './content/hirelist/moviecard/moviecard.component';
import { BtnComponent } from './common/btn/btn.component';
import { SearchfldComponent } from './common/searchfld/searchfld.component';
import { FormsModule } from '@angular/forms';
import { HistoryComponent } from './history/history.component';
import { MovecardmodalComponent } from './content/hirelist/movecardmodal/movecardmodal.component';
import { TabsDirective } from './common/tabs.directive';
import { YoutubeComponent } from './common/youtube/youtube.component';

import { MoviesService } from './services/movies.service';

const appRoutes: Routes = [
  { path: '', component: MainComponent, data: {type: 'app'} },
  { path: 'login', component: LoginComponent, data: {type: 'public'} },
  { path: 'history', component: HistoryComponent, data: {type: 'app'} },
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
    YoutubeComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    ),
    BrowserModule,
    FormsModule
  ],
  providers: [MoviesService], // service.ts вспомогательные сущности (прописываем свои компоненты)
  bootstrap: [AppComponent]
})
export class AppModule { }
