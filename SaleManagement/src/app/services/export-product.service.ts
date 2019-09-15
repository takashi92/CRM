import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../domain/product';

@Injectable({
  providedIn: 'root'
})
export class ExportProductService {

  constructor(private http: HttpClient) { }

  getFilteredProduct(filteredBrand, filteredName, filteredColor, filteredSize) {
    // return this.http.get<any>('http://127.0.0.1:8080/salesmanagement/product')
    //   .toPromise()
    //   .then(res => <Product[]>res.data);
    return this.http.get<any>('api/salesmanagement/product')
      .toPromise()
      .then(res => <Product[]>res.data);
  }
}
