import { Component, OnInit } from '@angular/core';
import { BillSearchService } from 'src/app/services/bill-search.service';
import { SelectItem } from 'primeng/api';
import { BillSearch } from 'src/app/domain/billsearch';
import { BillDetail } from 'src/app/domain/billdetail';

@Component({
  selector: 'app-bill-search',
  templateUrl: './bill-search.component.html',
  styleUrls: ['./bill-search.component.scss']
})
export class BillSearchComponent implements OnInit {

  billSearchs: BillSearch[];

  selectedBills: BillDetail[];

  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;
  cols: any[];
  constructor(private billSearchService: BillSearchService) { }

  ngOnInit() {
    this.billSearchService.getBillSearch().then(billSearchs => this.billSearchs = billSearchs);

    this.sortOptions = [
      { label: 'Newest First', value: '!year' },
      { label: 'Oldest First', value: 'year' },
      { label: 'Brand', value: 'brand' }
    ];

    this.cols = [
      { field: 'brand', header: 'Thương hiệu' },
      { field: 'name', header: 'Tên sản phẩm' },
      { field: 'code', header: 'Mã sản phẩm' },
      { field: 'color', header: 'Màu sắc' },
      { field: 'size', header: 'Kích thước' },
      { field: 'material', header: 'Chất liệu' },
      { field: 'stickerPrice', header: 'Giá niêm yết' },
      { field: 'sellNumber', header: 'Số lượng bán' },
      { field: 'discount', header: 'Khuyến mại' },
      { field: 'amountPrice', header: 'Thành tiền' },
      { field: 'note', header: 'Ghi chú' },
      { field: 'payment', header: 'Hình thức thanh toán' },
      { field: 'paymentNote', header: 'Thông tin thanh toán' },
    ];
  }

  selectBill(event: Event, bill: BillSearch) {
    this.billSearchService.getBillDetail(bill.billId).then(billdetail => this.selectedBills = billdetail);
    this.displayDialog = true;
    event.preventDefault();
  }

  onSortChange(event) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    }
    else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  onDialogHide() {
    this.selectedBills = null;
  }

  searchBill() {

  }

}
