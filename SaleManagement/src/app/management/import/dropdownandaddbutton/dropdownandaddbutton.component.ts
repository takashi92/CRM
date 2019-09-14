import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-dropdownandaddbutton',
  templateUrl: './dropdownandaddbutton.component.html',
  styleUrls: ['./dropdownandaddbutton.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class DropdownandaddbuttonComponent implements OnInit {
  filteredBrands = [
    { label: 'Audi', value: 'Audi' },
    { label: 'BMW', value: 'BMW' },
    { label: 'Fiat', value: 'Fiat' },
    { label: 'Ford', value: 'Ford' },
    { label: 'Honda', value: 'Honda' },
    { label: 'Jaguar', value: 'Jaguar' },
    { label: 'Mercedes', value: 'Mercedes' },
    { label: 'Renault', value: 'Renault' },
    { label: 'VW', value: 'VW' },
    { label: 'Volvo', value: 'Volvo' }
  ];
  brandName : string;

  constructor() { }

  ngOnInit() {
  }

}
