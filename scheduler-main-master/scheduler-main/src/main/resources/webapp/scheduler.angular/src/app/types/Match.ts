import Team from "./Team";
import Referee from "./Referee";
import Schedule from "./Schedule";

interface Match {
  id: number;
  type: string;
  date_time: Date;
  stadium: string;
  schedule: Schedule;
  referee: Referee;
  homeTeam: Team;
  awayTeam: Team;
  timeSlot: {
    id: number;
    localDateTime: Date;
  };
}

export interface MatchDisplay {
  id: number;
  type: string;
  date_time: Date;
  stadium: string;
  schedule: string;
  referee: string;
  homeTeam: string;
  awayTeam: string;
  timeSlot: Date;
}

export function matchToMatchDisplay(match: Match): MatchDisplay {
  return {
    ...match,
    schedule: match.schedule?.name,
    homeTeam: match.homeTeam?.name,
    awayTeam: match.homeTeam?.name,
    referee: match.referee?.name,
    timeSlot: match.timeSlot?.localDateTime
  }
}

export default Match;
