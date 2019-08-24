import { Component, OnInit } from '@angular/core';
import { WarehouseService } from 'src/app/services/warehouse.service';
import { Product, ProductSample } from 'src/app/domain/product';
@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss'],
  providers: [WarehouseService]
})
export class WarehouseComponent implements OnInit {
  displayDialog: boolean;

  product: Product = new ProductSample();

  selectedProduct: Product;

  newProduct: boolean;

  products: Product[];

  cols: any[];


  constructor(private warehouseService: WarehouseService) { }

  ngOnInit() {

    this.warehouseService.getProductData().then(products => this.products = products);

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

}

