import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertOrUpdateFormComponent } from './insert-or-update-form.component';

describe('InsertOrUpdateFormComponent', () => {
  let component: InsertOrUpdateFormComponent;
  let fixture: ComponentFixture<InsertOrUpdateFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertOrUpdateFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertOrUpdateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
