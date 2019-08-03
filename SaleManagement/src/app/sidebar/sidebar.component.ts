import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  items: MenuItem[];

  constructor() { }

  ngOnInit() {
    this.items = [
      {
        label: 'Quản lý',
        icon: 'pi pi-pw pi-folder',
        items: [
        { label: 'Nhập hàng', icon: 'pi pi-fw pi-window-minimize', routerLink:'/management/import'},
        { separator: true },
        { label: 'Bán hàng', icon: 'pi pi-fw pi-shopping-cart', routerLink:'/management/export'},
        { separator: true },
        { label: 'Kho hàng', icon: 'pi pi-fw pi-home', routerLink:'/management/warehouse' }
        ]
      }
    ];

  }

}
