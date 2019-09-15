import { Component, OnInit } from '@angular/core';
import { WarehouseService } from 'src/app/services/warehouse.service';
import { Product } from 'src/app/domain/product';
@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss'],
  providers: [WarehouseService]
})
export class WarehouseComponent implements OnInit {
  products: Product[];

  constructor(private warehouseService: WarehouseService) { }

  ngOnInit() {
    this.warehouseService.getProductData().then(products => this.products = products);
  }
}

