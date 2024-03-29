import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ChartModule} from 'primeng/chart';
import { AppComponent } from './app.component';
import { ReviewComponent } from './components/review/review.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {
  FieldsetModule,
  CalendarModule,
  InputTextModule,
  ProgressSpinnerModule,
  DialogModule,
  TabViewModule,
  DropdownModule,
  InputTextareaModule,
  MessagesModule,
  MessageModule,
  PanelModule,
  AccordionModule,
  ConfirmDialogModule,
  GrowlModule,
  CheckboxModule,
  RadioButtonModule,
  CarouselModule,
  MessageService,
} from 'primeng/primeng';
import {TooltipModule} from 'primeng/tooltip';
import { ButtonModule } from 'primeng/button';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CardModule} from 'primeng/card';
@NgModule({
  declarations: [
    AppComponent,
    ReviewComponent
  ],
  imports: [
    CardModule,
    CarouselModule,
    ToastModule,
    TableModule,
    TooltipModule,
    ButtonModule,
    FormsModule,
    PanelModule,
    ReactiveFormsModule,
    BrowserModule,
    ChartModule,
    AppRoutingModule,
    HttpClientModule,
    FieldsetModule,
    CalendarModule,
    InputTextModule,
    ProgressSpinnerModule,
    DialogModule,
    TabViewModule,
    DropdownModule,
    InputTextareaModule,
    MessagesModule,
    MessageModule,
    PanelModule,
    AccordionModule,
    ConfirmDialogModule,
    GrowlModule,
    CheckboxModule,
    RadioButtonModule,
    BrowserAnimationsModule,
  ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
