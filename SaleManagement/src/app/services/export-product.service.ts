import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../domain/product';

@Injectable({
  providedIn: 'root'
})
export class ExportProductService {

  constructor(private http: HttpClient) { }

  getFilteredProduct(filteredBrand, filteredName, filteredColor, filteredSize) {
    return [
      {
        brand: 'aaa',
        name: 'aaa',
        color: 'aaa',
        size: 'aaa',
        number: 'aaa',
        stickerPrice: 'aaa'
      }, {
        brand: 'aaa',
        name: 'aaa',
        color: 'aaa',
        size: 'aaa',
        number: 'aaa',
        stickerPrice: 'aaa'
      }, {
        brand: 'aaa',
        name: 'aaa',
        color: 'aaa',
        size: 'aaa',
        number: 'aaa',
        stickerPrice: 'aaa'
      }
    ];
  }
}
