import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatchDisplay } from 'src/app/types/Match';

@Component({
  selector: 'app-update-match-table',
  templateUrl: './update-match-table.component.html',
  styleUrls: ['./update-match-table.component.css']
})
export class UpdateMatchTableComponent {
  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }

  goToForm({ id }: MatchDisplay) {
    console.log(this.router);
  }
}
