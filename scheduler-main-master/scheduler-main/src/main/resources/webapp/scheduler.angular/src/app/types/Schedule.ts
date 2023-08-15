import Match from "./Match";
import Team from "./Team";
import User from "./User";

export enum ScheduleType {
  ROUNDROBIN,
  KNOCKOUT,
  DOUBLERR,
  GROUPSTAGEANDKNOCKOUT
}

interface Schedule {
  id: number;
  name: string;
  type: ScheduleType;
  startDate: Date;
  endDate: Date;
  matchesList: Match[];
  teams: Team[];
  User: User;
}

export default Schedule;
