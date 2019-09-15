import { Component, OnInit } from '@angular/core';
import { Product, Properties } from 'src/app/domain/product';
import { SelectItem } from 'primeng/api';
import { ImportProductService } from 'src/app/services/import-product.service';

@Component({
  selector: 'app-insertmode',
  templateUrl: './insertmode.component.html',
  styleUrls: ['./insertmode.component.scss']
})
export class InsertmodeComponent implements OnInit {
  product: Product = new Product();
  selectedProduct: Product;
  newProduct: boolean;
  displayDialog: boolean;
  products: Product[];
  cols: any[];

  filteredBrands: SelectItem[];
  filteredMaterials: SelectItem[];
  filteredColors: SelectItem[];
  filteredSizes: SelectItem[];

  constructor(private importProductService: ImportProductService) {
    this.product.parser(null, null, null, new Properties(), null, 0, 0, 0, 0, null, null);
    this.filterBrand();
    this.filterMaterial();
    this.filterColor();
    this.filterMaterial();
    this.filterSize();
  }

  ngOnInit() {
    this.products = [];
    this.cols = [
      { field: 'brandName', header: 'Nhãn hàng' },
      { field: 'name', header: 'Tên sản phẩm' },
      { field: 'properties.code', header: 'Mã sản phẩm' },
      { field: 'properties.material', header: 'Chất liệu' },
      { field: 'properties.description', header: 'Mô tả sản phẩm' },
      { field: 'properties.color', header: 'Màu sắc' },
      { field: 'properties.size', header: 'Kích cỡ' },
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
    this.product = new Product();
    this.product.parser(null, null, null, new Properties(), null, 0, 0, 0, 0, null, null);
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

  pushImportedProduct() {

  }

  emptyImportedProduct() {
    this.products = [];
  }
}
