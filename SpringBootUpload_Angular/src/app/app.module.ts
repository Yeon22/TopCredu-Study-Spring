import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListUploadComponent } from './upload/list-upload/list-upload.component';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { DetailsUploadComponent } from './upload/details-upload/details-upload.component';
import { UploadFileService } from './upload/upload-file.service';

@NgModule({
  declarations: [
    AppComponent,
    ListUploadComponent,
    FormUploadComponent,
    DetailsUploadComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
