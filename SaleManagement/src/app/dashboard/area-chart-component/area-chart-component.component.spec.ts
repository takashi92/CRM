import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaChartComponentComponent } from './area-chart-component.component';

describe('AreaChartComponentComponent', () => {
  let component: AreaChartComponentComponent;
  let fixture: ComponentFixture<AreaChartComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AreaChartComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AreaChartComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
