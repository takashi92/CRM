import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/domain/product';

import { ExportProductService } from 'src/app/services/export-product.service';
import { BillDetail, BillDetailSample } from 'src/app/domain/billdetail';
@Component({
  selector: 'app-export',
  templateUrl: './export.component.html',
  styleUrls: ['./export.component.scss']
})
export class ExportComponent implements OnInit {
  filter: Product = new Product();
  filteredBrand: any[] = [];
  filteredName: any[] = [];
  filteredMaterial: any[] = [];
  filteredColor: any[] = [];
  filteredSize: any[] = [];
  filteredProducts: Product[];

  displayDialog: boolean;
  newProduct: boolean;
  billDetail: BillDetail = new BillDetailSample(this.filter, null, 10, null, "", "bank", null, null);;
  billDetails: BillDetail[];
  selectedBillDetail: BillDetail;
  cols: any[];

  constructor(private exportProductService: ExportProductService) {
  }



  ngOnInit() {
    this.searchProduct();
    this.billDetails = [];
    this.cols = [
      { field: 'selectedProduct.brandName', header: 'Thương hiệu' },
      { field: 'selectedProduct.name', header: 'Tên sản phẩm' },
      { field: 'selectedProduct.properties.code', header: 'Mã sản phẩm' },
      { field: 'selectedProduct.properties.color', header: 'Màu sắc' },
      { field: 'selectedProduct.properties.size', header: 'Kích thước' },
      { field: 'selectedProduct.properties.material', header: 'Chất liệu' },
      { field: 'selectedProduct.stickerPrice', header: 'Giá niêm yết' },
      { field: 'sellNumber', header: 'Số lượng bán' },
      { field: 'discount', header: 'Khuyến mại' },
      { field: 'amountPrice', header: 'Thành tiền' },
      { field: 'note', header: 'Ghi chú' },
      { field: 'payment', header: 'Hình thức thanh toán' },
      { field: 'paymentNote', header: 'Thông tin thanh toán' },
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
    this.exportProductService.getFilteredProduct(this.filter.brandName, this.filter.name
      , this.filter.properties.color, this.filter.properties.size)
      .then(res => this.filteredProducts);
  }

  selectProduct(selectedProduct: Product) {
    if (selectedProduct) {
      this.newProduct = true;
      let defaultAmount = (selectedProduct.stickerPrice - (selectedProduct.stickerPrice / 100 * 10)) * selectedProduct.number;
      this.billDetail = new BillDetailSample(selectedProduct, selectedProduct.number, 10, defaultAmount, "", "bank", null, null);
      this.displayDialog = true;
    }
  }

  save() {
    const billDetails = [...this.billDetails];
    if (this.newProduct) {
      billDetails.push(this.billDetail);
    } else {
      billDetails[this.findSelectedBillDetailIndex()] = this.billDetail;
    }
    this.billDetails = billDetails;
    this.billDetail = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.findSelectedBillDetailIndex();
    this.billDetails = this.billDetails.filter((val, i) => i !== index);
    this.billDetail = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newProduct = false;
    this.billDetail = { ...event.data };
    this.displayDialog = true;
  }

  findSelectedBillDetailIndex(): number {
    return this.billDetails.indexOf(this.selectedBillDetail);
  }

  saveBillDetails() {

  }

  emptyBillDetails() {
    this.billDetails = [];
  }

}

