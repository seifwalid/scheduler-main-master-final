import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteMatchTableComponent } from './delete-match-table.component';

describe('DeleteMatchFormComponent', () => {
  let component: DeleteMatchTableComponent;
  let fixture: ComponentFixture<DeleteMatchTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeleteMatchTableComponent]
    });
    fixture = TestBed.createComponent(DeleteMatchTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
