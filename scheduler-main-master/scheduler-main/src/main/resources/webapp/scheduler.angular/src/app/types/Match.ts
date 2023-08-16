import Team from "./Team";
import Referee from "./Referee";
import Schedule from "./Schedule";
import { arrayDateToString } from "../utils/date";

interface Match {
  id: number;
  type: string;
  date_time: number[];
  stadium: string;
  schedule: Schedule;
  referee: Referee;
  homeTeam: Team;
  awayTeam: Team;
  timeSlot: {
    id: number;
    localDateTime: number[];
  };
}

export interface MatchDisplay {
  id: number;
  type: string;
  date_time: string;
  stadium: string;
  schedule: string | number;
  referee: string | number;
  homeTeam: string | number;
  awayTeam: string | number;
  timeSlot: string | number;
}

export interface MatchFormData {
  id: number;
  type: string;
  date_time: string;
  stadium: string;
  schedule: number;
  referee: number;
  homeTeam: number;
  awayTeam: number;
  timeSlot: number;
}

export function matchToMatchDisplay(match: Match): MatchDisplay {
  return {
    ...match,
    date_time: arrayDateToString(match.date_time),
    schedule: match.schedule?.name,
    homeTeam: match.homeTeam?.name,
    awayTeam: match.awayTeam?.name,
    referee: match.referee?.name,
    timeSlot: arrayDateToString(match.timeSlot?.localDateTime)
  }
}

export function matchToMatchFormData(match: Match): MatchFormData {
  return {
    ...match,
    date_time: arrayDateToString(match.date_time),
    schedule: match.schedule?.id,
    homeTeam: match.homeTeam?.id,
    awayTeam: match.homeTeam?.id,
    referee: match.referee?.id,
    timeSlot: match.timeSlot?.id
  }
}

export default Match;
