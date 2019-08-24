import { Component, OnInit } from '@angular/core';
import { Product, ProductSample } from 'src/app/domain/product';
import { ImportProductService } from 'src/app/services/import-product.service';

@Component({
  selector: 'app-import',
  templateUrl: './import.component.html',
  styleUrls: ['./import.component.scss']
})
export class ImportComponent implements OnInit {
  product: Product = new ProductSample();
  selectedProduct: Product;
  newProduct: boolean;
  displayDialog: boolean;
  products: Product[];
  cols: any[];

  filteredBrand: any[];
  filteredName: any[];
  filteredMaterial: any[];
  filteredColor: any[];
  filteredSize: any[];
  filteredStickerPrice: any[];

  constructor(private importProductService: ImportProductService) { }

  ngOnInit() {
    this.products = [];
    this.cols = [
      { field: 'brand', header: 'Nhãn hàng' },
      { field: 'name', header: 'Tên sản phẩm' },
      { field: 'code', header: 'Mã sản phẩm' },
      { field: 'material', header: 'Chất liệu' },
      { field: 'description', header: 'Mô tả sản phẩm' },
      { field: 'color', header: 'Màu sắc' },
      { field: 'size', header: 'Kích cỡ' },
      { field: 'number', header: 'Số lượng' },
      { field: 'stickerPrice', header: 'Giá niêm yết trên một sản phẩm' },
      { field: 'importedPrice', header: 'Giá nhập trên một sản phẩm' },
      { field: 'importAmount', header: 'Tổng tiền nhập' },
      { field: 'created', header: 'Ngày nhập' },
      { field: 'updated', header: 'Ngày cập nhật' },
      { field: 'note', header: 'Ghi chú' }
    ];
  }

  showDialogToAdd() {
    this.newProduct = true;
    this.product = new ProductSample();
    this.displayDialog = true;
  }

  save() {
    const products = [...this.products];
    if (this.newProduct) {
      products.push(this.product);
    } else {
      products[this.findSelectedProductIndex()] = this.product;
    }
    this.products = products;
    this.product = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.findSelectedProductIndex();
    this.products = this.products.filter((val, i) => i !== index);
    this.product = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newProduct = false;
    this.product = { ...event.data };
    this.displayDialog = true;
  }

  findSelectedProductIndex(): number {
    return this.products.indexOf(this.selectedProduct);
  }

  filterBrand(event) {
    this.filteredBrand = this.importProductService.getFilteredBrand(event.query);
  }

  filterName(event) {
    this.filteredName = this.importProductService.getFilteredName(event.query);
  }

  filterMaterial(event) {
    this.filteredMaterial = this.importProductService.getFilteredMaterial(event.query);
  }

  filterColor(event) {
    this.filteredColor = this.importProductService.getFilteredColor(event.query);
  }

  filterSize(event) {
    this.filteredSize = this.importProductService.getFilteredSize(event.query);
  }

  filterStickerPrice(event) {
    this.filteredStickerPrice = this.importProductService.getFilteredStickerPrice(event.query);
  }

  handleDropdown(event) {
    //event.query = current value in input field
  }


  pushImportedProduct() {

  }

  emptyImportedProduct() {
    this.products = [];
  }
}
