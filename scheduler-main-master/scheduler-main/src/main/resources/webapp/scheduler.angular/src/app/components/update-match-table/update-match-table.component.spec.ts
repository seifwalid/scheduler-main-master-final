import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMatchTableComponent } from './update-match-table.component';

describe('UpdateMatchFormComponent', () => {
  let component: UpdateMatchTableComponent;
  let fixture: ComponentFixture<UpdateMatchTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateMatchTableComponent]
    });
    fixture = TestBed.createComponent(UpdateMatchTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
