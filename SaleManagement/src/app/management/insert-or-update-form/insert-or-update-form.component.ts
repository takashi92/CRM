import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Product } from 'src/app/domain/product';
import { SelectItem } from 'primeng/api';
import { ImportProductService } from 'src/app/services/import-product.service';

@Component({
  selector: 'app-insert-or-update-form',
  templateUrl: './insert-or-update-form.component.html',
  styleUrls: ['./insert-or-update-form.component.scss']
})
export class InsertOrUpdateFormComponent implements OnInit {
  @Input() product: Product;
  @Output() save = new EventEmitter();
  @Output() delete = new EventEmitter();
  filteredBrands: SelectItem[];
  filteredMaterials: SelectItem[];
  filteredColors: SelectItem[];
  filteredSizes: SelectItem[];
  constructor(private importProductService: ImportProductService) {
    this.filterBrand();
    this.filterMaterial();
    this.filterColor();
    this.filterMaterial();
    this.filterSize();
  }

  ngOnInit() {
  }

  doSelect(event) {
    console.log(event);
  }

  filterBrand() {
    this.filteredBrands = this.importProductService.getFilteredBrand();
  }


  filterMaterial() {
    this.filteredMaterials = this.importProductService.getFilteredMaterial();
  }

  filterColor() {
    this.filteredColors = this.importProductService.getFilteredColor();
  }

  filterSize() {
    this.filteredSizes = this.importProductService.getFilteredSize();
  }

  getAmountPrice() {
    if (this.product.importAmount) {
      return this.product.importAmount;
    }
    if (this.product.importedPrice && this.product.number) {
      return this.product.importedPrice * this.product.number;
    }
    return 0;
  }

}
