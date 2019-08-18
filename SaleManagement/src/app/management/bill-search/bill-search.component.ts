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

}
