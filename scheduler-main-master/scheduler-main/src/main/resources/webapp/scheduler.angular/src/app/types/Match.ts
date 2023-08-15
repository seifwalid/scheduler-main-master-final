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
  timeSlot: Date;
}

export default Match;
