import Match from "./Match";

interface Referee {
  id: number;
  name?: string;
  matches?: Match[];
}

export default Referee;
