import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { tap } from 'rxjs';
import { MatchService } from 'src/app/services/match.service';
import { RefereeService } from 'src/app/services/referee.service';
import { ScheduleService } from 'src/app/services/schedule.service';
import { TeamService } from 'src/app/services/team.service';
import { TimeSlotService } from 'src/app/services/time-slot.service';
import { MatchFormData } from 'src/app/types/Match';
import { arrayDateToString, dateToString } from 'src/app/utils/date';

@Component({
  selector: 'app-update-match-form',
  templateUrl: './update-match-form.component.html',
  styleUrls: ['./update-match-form.component.css']
})
export class UpdateMatchFormComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private matchService: MatchService,
    private scheduleService: ScheduleService,
    private refereeService: RefereeService,
    private teamService: TeamService,
    private timeSlotServie: TimeSlotService,
  ) { }

  matchId!: number;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.matchService.setFetchId(params['id'])
    }).unsubscribe();
    this.matchService.match$.subscribe(match => {
      this.matchId = match.id;
      this.matchForm.setValue({
        type: match?.type,
        date_time: match?.date_time,
        stadium: match?.stadium,
        schedule: match?.schedule,
        homeTeam: match?.homeTeam,
        awayTeam: match?.awayTeam,
        referee: match?.referee,
        timeSlot: match?.timeSlot,
      })
    });
  }

  $initialMatch = this.matchService.match$;

  matchForm = new FormGroup({
    type: new FormControl(''),
    date_time: new FormControl(''),
    stadium: new FormControl(''),
    schedule: new FormControl(0),
    homeTeam: new FormControl(0),
    awayTeam: new FormControl(0),
    referee: new FormControl(0),
    timeSlot: new FormControl(0),
  });

  referees$ = this.refereeService.referees$;
  teams$ = this.teamService.teams$;
  schedules$ = this.scheduleService.schedules$;

  submitForm() {
    this.matchService.updateMatch(this.matchId, this.matchForm.value)
  }
}
