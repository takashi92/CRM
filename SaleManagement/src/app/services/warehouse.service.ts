import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../domain/product';
@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  constructor(private http: HttpClient) { }

  getProductData() {
    return this.http.get<any>('api/products')
      .toPromise()
      .then(res => <Product[]>res);
  }

}
