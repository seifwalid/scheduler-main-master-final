import { Injectable } from '@angular/core';
import { apiDir, del, post } from '../utils/api';
import { fromFetch } from 'rxjs/fetch';
import Match, { matchToMatchDisplay } from '../types/Match';
import { BehaviorSubject, Subject, map, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  private fetchSignal$ = new BehaviorSubject(0);
  private fetchedMatches$ = fromFetch(apiDir("match/matches"), {
    selector: response => response.json() as Promise<Match[]>
  }).pipe(
    map((matches: Match[]) => matches.map(matchToMatchDisplay))
  )

  matches$ = this.fetchSignal$.pipe(
    switchMap(() => this.fetchedMatches$)
  )

  async addMatch(matchData: Partial<Record<keyof Match, string | null>>) {
    const newMatch = {
      type: matchData.type,
      date_time: matchData.date_time,
      stadium: matchData.stadium,
      schedule: matchData.schedule,
      referee: matchData.referee,
      homeTeam: matchData.homeTeam,
      awayTeam: matchData.awayTeam,
      timeSlot: 1
    }

    return post("match/addmatch", newMatch).then(response => {
      console.log(response);
      this.refreshMatches();
    });
  }

  async delMatch(id: number) {
    return del(`match/${id}`).then(response => {
      console.log(response);
      this.refreshMatches();
    });
  }

  refreshMatches() {
    this.fetchSignal$.next(0);
  }

  constructor() { }
}
