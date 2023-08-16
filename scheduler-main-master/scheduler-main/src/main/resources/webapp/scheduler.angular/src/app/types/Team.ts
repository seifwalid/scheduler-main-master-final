import Match from "./Match";

interface Team {
  id: number;
  name: string;
  stadium: string;
  homeMatches?: Match[];
  awayMatches?: Match[];
}

export default Team;
