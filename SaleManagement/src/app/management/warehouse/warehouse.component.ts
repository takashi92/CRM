import { Component, OnInit } from '@angular/core';
import { WarehouseService } from 'src/app/services/warehouse.service';
import { Warehouse } from 'src/app/domain/warehouse';
@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss'],
  providers: [WarehouseService]
})
export class WarehouseComponent implements OnInit {
  displayDialog: boolean;

  product: Warehouse = new WarehouseSample();

  selectedProduct: Warehouse;

  newProduct: boolean;

  products: Warehouse[];

  cols: any[];


  constructor(private warehouseService: WarehouseService) { }

  ngOnInit() {

    this.warehouseService.getProductData().then(products => this.products = products);

    this.cols = [
      { field: 'brand', header: 'Nhãn hàng' },
      { field: 'name', header: 'Tên sản phẩm' },
      { field: 'code', header: 'Mã sản phẩm' },
      { field: 'bar_code', header: 'Mã vạch' },
      { field: 'material', header: 'Chất liệu' },
      { field: 'description', header: 'Mô tả sản phẩm' },
      { field: 'color', header: 'Màu sắc' },
      { field: 'size', header: 'Size' },
      { field: 'note', header: 'Ghi chú' },
      { field: 'created', header: 'Ngày nhập' },
      { field: 'updated', header: 'Ngày cập nhật' } 
    ];
  }

  showDialogToAdd() {
    this.newProduct = true;
    this.product = new WarehouseSample();
    this.displayDialog = true;
  }

  save() {
    const products = [...this.products];
    if (this.newProduct) {
      products.push(this.product);
    } else {
      products[this.findSelectedCarIndex()] = this.product;
    }
    this.products = products;
    this.product = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.findSelectedCarIndex();
    this.products = this.products.filter((val, i) => i !== index);
    this.product = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newProduct = false;
    this.product = { ...event.data };
    this.displayDialog = true;
  }

  findSelectedCarIndex(): number {
    return this.products.indexOf(this.selectedProduct);
  }

}

export class WarehouseSample implements Warehouse {
  constructor(
    public brand?,
    public name?,
    public code?,
    public bar_code?,
    public material?,
    public description?,
    public color?,
    public size?,
    public note?,
    public created?,
    public updated?) { }
}
