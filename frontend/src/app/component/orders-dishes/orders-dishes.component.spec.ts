import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersDishesComponent } from './orders-dishes.component';

describe('OrdersDishesComponent', () => {
  let component: OrdersDishesComponent;
  let fixture: ComponentFixture<OrdersDishesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrdersDishesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersDishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
