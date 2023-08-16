import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TimeSlotService {

  constructor() { }

  timeSlot$ = of([{
    id: 1,
    date: new Date()
  }]);
}
