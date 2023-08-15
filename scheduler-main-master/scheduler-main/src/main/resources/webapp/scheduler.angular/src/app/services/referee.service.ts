import { Injectable } from '@angular/core';
import { fromFetch } from 'rxjs/fetch';
import { apiDir } from '../utils/api';
import Referee from '../types/Referee';

@Injectable({
  providedIn: 'root'
})
export class RefereeService {
  referees$ = fromFetch(apiDir("referee"), {
    selector: response => response.json() as Promise<Referee[]>
  });

  constructor() { }
}
