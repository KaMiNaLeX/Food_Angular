import { TestBed } from '@angular/core/testing';

import { ClientDishesService } from './client-dishes.service';

describe('ClientDishesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClientDishesService = TestBed.get(ClientDishesService);
    expect(service).toBeTruthy();
  });
});
