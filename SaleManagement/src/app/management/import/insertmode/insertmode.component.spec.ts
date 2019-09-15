import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertmodeComponent } from './insertmode.component';

describe('InsertmodeComponent', () => {
  let component: InsertmodeComponent;
  let fixture: ComponentFixture<InsertmodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertmodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertmodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
