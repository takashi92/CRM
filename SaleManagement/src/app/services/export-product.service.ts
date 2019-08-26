import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../domain/product';

@Injectable({
  providedIn: 'root'
})
export class ExportProductService {

  constructor(private http: HttpClient) { }

  getFilteredProduct(filteredBrand, filteredName, filteredColor, filteredSize) {
    return this.http.get<any>('assets/data/warehouse-sample.json')
      .toPromise()
      .then(res => <Product[]>res.data)
      .then(data => data);
  }
}
