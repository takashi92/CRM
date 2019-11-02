import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { Product } from 'src/app/domain/product';
import { SelectItem } from 'primeng/api';
import {
  trigger,
  state,
  style,
  transition,
  animate
} from '@angular/animations';
@Component({
  selector: 'app-dataview',
  templateUrl: './dataview.component.html',
  styleUrls: ['./dataview.component.scss'],
  animations: [
    trigger('rowExpansionTrigger', [
      state(
        'void',
        style({
          transform: 'translateX(-10%)',
          opacity: 0
        })
      ),
      state(
        'active',
        style({
          transform: 'translateX(0)',
          opacity: 1
        })
      ),
      transition('* <=> *', animate('400ms cubic-bezier(0.86, 0, 0.07, 1)'))
    ])
  ]
})
export class DataviewComponent implements OnInit {
  @Input() products: Product[];
  selectedProduct: Product;
  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;
  cols: any[];
  constructor() {}

  ngOnInit() {
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

    this.sortOptions = [
      { label: 'Newest First', value: '!year' },
      { label: 'Oldest First', value: 'year' },
      { label: 'Brand', value: 'brand' }
    ];
  }

  selectProduct(event: Event, product: Product) {
    this.selectedProduct = product;
    this.displayDialog = true;
    event.preventDefault();
  }

  onSortChange(event) {
    const value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    } else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  onDialogHide() {
    this.selectedProduct = null;
  }

  getProductViewData(product: Product) {
    return [product];
  }
}
