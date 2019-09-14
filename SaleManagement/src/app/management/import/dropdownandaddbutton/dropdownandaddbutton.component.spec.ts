import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DropdownandaddbuttonComponent } from './dropdownandaddbutton.component';

describe('DropdownandaddbuttonComponent', () => {
  let component: DropdownandaddbuttonComponent;
  let fixture: ComponentFixture<DropdownandaddbuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DropdownandaddbuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DropdownandaddbuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
