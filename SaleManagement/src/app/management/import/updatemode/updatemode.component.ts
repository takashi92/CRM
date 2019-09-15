import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/domain/product';
import { BillDetailSample } from 'src/app/domain/billdetail';
import { ImportProductService } from 'src/app/services/import-product.service';
import { SelectItem } from 'primeng/api';

@Component({
  selector: 'app-updatemode',
  templateUrl: './updatemode.component.html',
  styleUrls: ['./updatemode.component.scss']
})
export class UpdatemodeComponent implements OnInit {
  filteredBrand: any[] = [];
  filteredName: any[] = [];
  filteredMaterial: any[] = [];
  filteredColor: any[] = [];
  filteredSize: any[] = [];

  filter: Product = new Product();
  filteredProducts: Product[];
  selectedProduct: Product;
  displayDialog: boolean;
  sortOptions: SelectItem[];
  sortKey: string;
  sortField: string;
  sortOrder: number;

  constructor(private importProductService: ImportProductService) {
  }



  ngOnInit() {
    this.searchProduct();
    this.sortOptions = [
      { label: 'Newest First', value: '!year' },
      { label: 'Oldest First', value: 'year' },
      { label: 'Brand', value: 'brand' }
    ];
  }
  filterBrand(event) {
    this.filteredBrand = ['Audi', 'BMW', 'Fiat', 'Ford', 'Honda', 'Jaguar', 'Mercedes', 'Renault', 'Volvo', 'VW'];
  }

  filterName(event) {
  }


  filterMaterial(event) {
  }

  filterColor(event) {
  }

  filterSize(event) {
  }


  searchProduct() {
    this.importProductService.getFilteredProduct(this.filter.brandName, this.filter.name
      , this.filter.properties.color, this.filter.properties.size)
      .then(res => this.filteredProducts);
  }

  selectProduct(event: Event, selectedProduct: Product) {
    this.selectedProduct = selectedProduct;
    this.displayDialog = true;
    event.preventDefault();
  }

}
