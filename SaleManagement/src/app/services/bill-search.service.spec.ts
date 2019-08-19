import { TestBed } from '@angular/core/testing';

import { BillSearchService } from './bill-search.service';

describe('BillSearchService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BillSearchService = TestBed.get(BillSearchService);
    expect(service).toBeTruthy();
  });
});
