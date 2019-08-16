import { Component, OnInit } from '@angular/core';
import { BillSearchService } from 'src/app/services/bill-search.service';
import { SelectItem } from 'primeng/api';
import { BillSearch } from 'src/app/domain/billsearch';

@Component({
  selector: 'app-bill-search',
  templateUrl: './bill-search.component.html',
  styleUrls: ['./bill-search.component.scss']
})
export class BillSearchComponent implements OnInit {

  billSearchs: BillSearch[];

  selectedBill:BillSearch;

  displayDialog: boolean;

  sortOptions: SelectItem[];

  sortKey: string;

  sortField: string;

  sortOrder: number;
  constructor(private billSearchService: BillSearchService) { }

  ngOnInit() {
    this.billSearchService.getBillSearch().then(billSearchs => this.billSearchs = billSearchs);

    this.sortOptions = [
      { label: 'Newest First', value: '!year' },
      { label: 'Oldest First', value: 'year' },
      { label: 'Brand', value: 'brand' }
    ];
  }

  selectBill(event: Event, bill:BillSearch ) {
    this.selectedBill = bill;
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
    this.selectedBill = null;
  }

}
