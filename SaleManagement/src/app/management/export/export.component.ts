import { Component, OnInit } from '@angular/core';
import { Product, ProductSample } from 'src/app/domain/product';

import { ExportProductService } from 'src/app/services/export-product.service';
@Component({
  selector: 'app-export',
  templateUrl: './export.component.html',
  styleUrls: ['./export.component.scss']
})
export class ExportComponent implements OnInit {
  product: Product = new ProductSample();
  selectedProduct: Product;
  newProduct: boolean;
  displayDialog: boolean;
  products: Product[];
  cols: any[];

  filter: Product = new ProductSample();
  filteredBrand: any[] = [];
  filteredName: any[] = [];
  filteredMaterial: any[] = [];
  filteredColor: any[] = [];
  filteredSize: any[] = [];
  filteredProducts: Product[];

  constructor(private exportProductService: ExportProductService) {
  }

  ngOnInit() {
    this.cols = [
      { field: 'brand', header: 'Nhãn hàng' },
      { field: 'name', header: 'Tên sản phẩm' },
      { field: 'color', header: 'Màu sắc' },
      { field: 'size', header: 'Size' },
      { field: 'price', header: 'Đơn giá' },
      { field: 'number', header: 'Số lượng' },
      { field: 'discount', header: 'Giảm giá' },
      { field: 'created', header: 'Ngày bán' },
      { field: 'amount', header: 'Thành tiền' }
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
    this.exportProductService.getFilteredProduct(this.filter.brand, this.filter.name, this.filter.color, this.filter.size).then(products => this.filteredProducts = products);
  }

  selectProduct(selectedProduct: Product) {

  }

}

