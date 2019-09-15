import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { ViewEncapsulation } from '@angular/core';
import { ImportProductService } from '../../../services/import-product.service';

@Component({
  selector: 'app-dropdownandaddbutton',
  templateUrl: './dropdownandaddbutton.component.html',
  styleUrls: ['./dropdownandaddbutton.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class DropdownandaddbuttonComponent implements OnInit {
  @Input() options: SelectItem[];
  @Input() optionType: string;
  @Output() onSelectItem = new EventEmitter();
  displayDialog: boolean;
  property = {
    code: '',
    name: ''
  };

  constructor(private importService: ImportProductService) {}

  ngOnInit() {}

  selectItem(event) {
    this.onSelectItem.emit(event.value);
  }

  openCreateDialog() {
    this.displayDialog = true;
  }

  save() {
    this.importService.createProperty(this.optionType, this.property);
    this.displayDialog = false;
  }

  closeDialog() {
    this.displayDialog = false;
  }
}
