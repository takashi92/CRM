import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { Warehouse } from 'src/app/domain/warehouse';

import { WarehouseService } from 'src/app/services/warehouse.service';
@Component({
  selector: 'app-export',
  templateUrl: './export.component.html',
  styleUrls: ['./export.component.scss']
})
export class ExportComponent implements OnInit {

  selectedProduct: string = 'Chọn mã hàng';
  // products: Warehouse[];
  products: SelectItem[];
  items: SelectItem[];
  date: Date;
  item: string;
  cols: any[];
  constructor(private warehouseService: WarehouseService) {
    this.products = [
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
    this.items = [];
    for (let i = 0; i < 10000; i++) {
      this.items.push({ label: 'Item ' + i, value: 'Item ' + i });
    }

    this.date = new Date();
  }

  ngOnInit() {
    // this.warehouseService.getProductData().then(products => this.products = products);
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

}

