import { Injectable } from '@angular/core';
import { apiDir, del, get, post, put } from '../utils/api';
import { fromFetch } from 'rxjs/fetch';
import Match, { matchToMatchDisplay, matchToMatchFormData } from '../types/Match';
import { BehaviorSubject, Observable, Subject, map, of, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  private fetchMatchesSignal$ = new BehaviorSubject(0);
  private fetchedMatches$ = fromFetch(apiDir("match/matches"), {
    selector: response => response.json() as Promise<Match[]>
  }).pipe(
    map((matches: Match[]) => matches.map(matchToMatchDisplay))
  )

  matches$ = this.fetchMatchesSignal$.pipe(
    switchMap(() => this.fetchedMatches$)
  )

  private fetchMatchSignal$ = new BehaviorSubject(-1);
  match$ = this.fetchMatchSignal$.pipe(switchMap((id: number) => {
    if (id < 0) {
      return of([]);
    }
    return fromFetch(apiDir(`match/${id}`), {
      selector: response => response.json()
    })
  }), map(matchToMatchFormData))

  async addMatch(matchData: Partial<Record<keyof Match, string | number | null>>) {
    const newMatch = {
      ...matchData,
      timeSlot: 1
    }

    return post("match/addmatch", newMatch).then(response => {
      console.log(response);
      this.refreshMatches();
    });
  }

  async updateMatch(id: number, matchData: Partial<Record<keyof Match, string | number | null>>) {
    const newMatch = {
      ...matchData,
      timeSlot: 1
    }


    return put(`match/${id}`, newMatch).then(response => {
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

  setFetchId(id: number) {
    this.fetchMatchSignal$.next(id);
  }

  refreshMatches() {
    this.fetchMatchesSignal$.next(0);
  }

  constructor() { }
}
