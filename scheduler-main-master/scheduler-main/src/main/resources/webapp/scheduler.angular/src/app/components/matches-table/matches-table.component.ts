import { Component, Input } from '@angular/core';
import { MatchService } from 'src/app/services/match.service';
import { MatchDisplay } from 'src/app/types/Match';


@Component({
  selector: 'app-matches-table',
  templateUrl: './matches-table.component.html',
  styleUrls: ['./matches-table.component.css']
})
export class MatchesTableComponent {
  @Input()
  action?: (match: MatchDisplay) => void;
  @Input()
  actionIconClasses?: (string);

  constructor(private matchService: MatchService) {
  }

  matches$ = this.matchService.matches$;
}
