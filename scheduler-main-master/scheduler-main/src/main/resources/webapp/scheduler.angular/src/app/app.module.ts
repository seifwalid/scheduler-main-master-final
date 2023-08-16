import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { MenuModule } from 'primeng/menu';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog'
import { TableModule } from 'primeng/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from "@angular/common";
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AddMatchFormComponent } from './components/add-match-form/add-match-form.component';
import { UpdateMatchTableComponent } from './components/update-match-table/update-match-table.component';
import { DeleteMatchTableComponent } from './components/delete-match-table/delete-match-table.component';
import { MatchesTableComponent } from './components/matches-table/matches-table.component';
import { UpdateMatchFormComponent } from './components/update-match-form/update-match-form.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    NavbarComponent,
    AddMatchFormComponent,
    UpdateMatchTableComponent,
    DeleteMatchTableComponent,
    MatchesTableComponent,
    UpdateMatchFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    CommonModule,
    MenuModule,
    FormsModule,
    ReactiveFormsModule,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule,
    ConfirmDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
