import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api'

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  readonly items: MenuItem[] = [{
    label: "Matches Table",
    items: [{
      label: "ADD match",
      routerLink: "/addMatch"
    }, {
      label: "DEL match",
      routerLink: "/delMatch"
    }, {
      label: "UPDATE match",
      routerLink: "/updateMatch"
    }],
  }];
}
