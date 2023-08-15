import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMatchFormComponent } from './update-match-form.component';

describe('UpdateMatchFormComponent', () => {
  let component: UpdateMatchFormComponent;
  let fixture: ComponentFixture<UpdateMatchFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateMatchFormComponent]
    });
    fixture = TestBed.createComponent(UpdateMatchFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
