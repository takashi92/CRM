import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BillSearch } from '../domain/billsearch';
import { BillDetail } from '../domain/billdetail';

@Injectable({
  providedIn: 'root'
})
export class BillSearchService {

  constructor(private http: HttpClient) { }

  getBillSearch() {
    return this.http.get<any>('assets/data/bill-search.json')
      .toPromise()
      .then(res => <BillSearch[]>res.data)
      .then(data => data);
  }

  getBillDetail(billId:any) {
    return this.http.get<any>('assets/data/bill-detail.json')
      .toPromise()
      .then(res => <BillDetail[]>res.data)
      .then(data => data);
  }
}
