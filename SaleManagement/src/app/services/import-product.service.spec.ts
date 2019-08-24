import { TestBed } from '@angular/core/testing';

import { ImportProductService } from './import-product.service';

describe('ImportProductService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ImportProductService = TestBed.get(ImportProductService);
    expect(service).toBeTruthy();
  });
});
