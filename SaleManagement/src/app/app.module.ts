import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AccordionModule } from 'primeng/accordion';     //accordion and accordion tab
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog';

import { MenubarModule } from 'primeng/menubar';
import {PanelMenuModule} from 'primeng/panelmenu';
import { NavbarSearchComponentComponent } from './top-bar/navbar-search-component/navbar-search-component.component';
import { NavbarComponentComponent } from './top-bar/navbar-component/navbar-component.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';
import { SidebarComponentComponent } from './sidebar-component/sidebar-component.component';
import { DashboardComponentComponent } from './dashboard/dashboard-component/dashboard-component.component';
import { OverviewComponentComponent } from './dashboard/overview-component/overview-component.component';
import { AreaChartComponentComponent } from './dashboard/area-chart-component/area-chart-component.component';
import { DataTableComponentComponent } from './dashboard/data-table-component/data-table-component.component';
import { FooterComponentComponent } from './footer-component/footer-component.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarSearchComponentComponent,
    NavbarComponentComponent,
    SidebarComponentComponent,
    DashboardComponentComponent,
    OverviewComponentComponent,
    AreaChartComponentComponent,
    DataTableComponentComponent,
    FooterComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccordionModule,
    BrowserAnimationsModule,
    InputTextModule,
    DialogModule,
    ButtonModule, 
    MenubarModule,
    PanelMenuModule,
    NgbModule,
    NgbPaginationModule,
    NgbAlertModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
