import { Injectable } from '@angular/core';
import { fromFetch } from 'rxjs/fetch';
import { apiDir } from '../utils/api';
import Team from '../types/Team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  teams$ = fromFetch(apiDir("team"), {
    selector: response => response.json() as Promise<Team[]>
  });
  constructor() { }
}
