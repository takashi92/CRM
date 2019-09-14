import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/domain/product';
import { BillDetailSample } from 'src/app/domain/billdetail';
import { ImportProductService } from 'src/app/services/import-product.service';

@Component({
  selector: 'app-updatemode',
  templateUrl: './updatemode.component.html',
  styleUrls: ['./updatemode.component.scss']
})
export class UpdatemodeComponent implements OnInit {

  filter: Product = new Product();
  filteredBrand: any[] = [];
  filteredName: any[] = [];
  filteredMaterial: any[] = [];
  filteredColor: any[] = [];
  filteredSize: any[] = [];
  filteredProducts: Product[];

  displayDialog: boolean;
  newProduct: boolean;
  product: Product = new Product();
  selectedProduct: Product;
  products: Product[];
  cols: any[];

  constructor(private importProductService: ImportProductService) {
  }



  ngOnInit() {
    this.searchProduct();
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
    this.importProductService.getFilteredProduct(this.filter.brandName, this.filter.name
      , this.filter.properties.color, this.filter.properties.size)
      .then(res => this.filteredProducts);
  }

  selectProduct(selectedProduct: Product) {
    if (selectedProduct) {
      this.newProduct = true;
      let defaultAmount = (selectedProduct.stickerPrice - (selectedProduct.stickerPrice / 100 * 10)) * selectedProduct.number;
      this.displayDialog = true;
    }
  }

  save() {
    const billDetails = [...this.products];
    if (this.newProduct) {
      billDetails.push(this.product);
    } else {
      billDetails[this.findSelectedBillDetailIndex()] = this.product;
    }
    this.products = billDetails;
    this.product = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.findSelectedBillDetailIndex();
    this.products = this.products.filter((val, i) => i !== index);
    this.product = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newProduct = false;
    this.product = { ...event.data };
    this.displayDialog = true;
  }

  findSelectedBillDetailIndex(): number {
    return this.products.indexOf(this.selectedProduct);
  }

  saveBillDetails() {

  }

  emptyBillDetails() {
    this.products = [];
  }


}
