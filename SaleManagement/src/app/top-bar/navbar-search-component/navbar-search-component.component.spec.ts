import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarSearchComponentComponent } from './navbar-search-component.component';

describe('NavbarSearchComponentComponent', () => {
  let component: NavbarSearchComponentComponent;
  let fixture: ComponentFixture<NavbarSearchComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarSearchComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarSearchComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
