import { TestBed } from '@angular/core/testing';

import { ExportProductService } from './export-product.service';

describe('ExportProductService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExportProductService = TestBed.get(ExportProductService);
    expect(service).toBeTruthy();
  });
});
