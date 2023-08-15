import { Injectable } from '@angular/core';
import { apiDir, post } from '../utils/api';
import { fromFetch } from 'rxjs/fetch';
import Match from '../types/Match';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  matches$ = fromFetch(apiDir("match/matches"), {
    selector: response => response.json() as Promise<Match[]>
  })

  addMatch(matchData: Partial<Record<keyof Match, string | null>>) {
    const newMatch = {
      type: matchData.type,
      date_time: matchData.date_time,
      stadium: matchData.stadium,
      schedule: {
        id: matchData.schedule
      },
      referee: {
        id: matchData.referee
      },
      homeTeam: {
        id: matchData.homeTeam
      },
      awayTeam: {
        id: matchData.awayTeam
      }
    }

    post("match/addMatch", newMatch).then(response => console.log(response));
  }

  constructor() { }
}
