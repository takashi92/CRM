import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatemodeComponent } from './updatemode.component';

describe('UpdatemodeComponent', () => {
  let component: UpdatemodeComponent;
  let fixture: ComponentFixture<UpdatemodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatemodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatemodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
