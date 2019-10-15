import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Product } from '../../domain/product';

@Component({
  selector: 'app-dialog-edit-form',
  templateUrl: './dialog-edit-form.component.html',
  styleUrls: ['./dialog-edit-form.component.scss']
})
export class DialogEditFormComponent implements OnInit {
  @Input() label: string;
  @Input() @Output() displayDialog = true;
  @Input() selectedProduct: Product;
  @Output() save = new EventEmitter();
  @Output() delete = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  doSave(event) {
    this.save.emit(event);
  }
  
  doDelete(event) {
    this.delete.emit(event);
  }
}
