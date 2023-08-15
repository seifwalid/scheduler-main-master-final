import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatchService } from 'src/app/services/match.service';
import { RefereeService } from 'src/app/services/referee.service';
import { ScheduleService } from 'src/app/services/schedule.service';
import { TeamService } from 'src/app/services/team.service';

@Component({
  selector: 'app-add-match-form',
  templateUrl: './add-match-form.component.html',
  styleUrls: ['./add-match-form.component.css'],
})
export class AddMatchFormComponent implements OnInit {
  constructor(
    private refereeService: RefereeService,
    private teamService: TeamService,
    private scheduleService: ScheduleService,
    private matchService: MatchService) {
  }

  ngOnInit(): void {
  }

  matchForm = new FormGroup({
    type: new FormControl(''),
    date_time: new FormControl(''),
    stadium: new FormControl(''),
    schedule: new FormControl(''),
    homeTeam: new FormControl(''),
    awayTeam: new FormControl(''),
    referee: new FormControl(''),
    // timeSlots: new FormControl(''),
  });

  referees$ = this.refereeService.referees$;
  teams$ = this.teamService.teams$;
  schedules$ = this.scheduleService.schedules$;

  submitForm() {
    this.matchService.addMatch(this.matchForm.value);
  }
}
