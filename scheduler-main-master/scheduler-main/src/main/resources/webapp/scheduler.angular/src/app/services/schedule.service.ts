import { Injectable } from '@angular/core';
import { fromFetch } from 'rxjs/fetch';
import { apiDir } from '../utils/api';
import Schedule from '../types/Schedule';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  schedules$ = fromFetch(apiDir("schedule/getAllSchedules"), {
    selector: response => response.json() as Promise<Schedule[]>
  })

  constructor() { }
}
