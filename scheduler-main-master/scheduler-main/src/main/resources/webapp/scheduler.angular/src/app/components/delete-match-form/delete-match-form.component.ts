import { Component } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { MatchService } from 'src/app/services/match.service';

@Component({
  selector: 'app-delete-match-form',
  templateUrl: './delete-match-form.component.html',
  styleUrls: ['./delete-match-form.component.css'],
  providers: [ConfirmationService]
})
export class DeleteMatchFormComponent {
  constructor(
    private confirmationService: ConfirmationService,
    private matchService: MatchService
  ) { }

  promptDelete(id: number) {
    this.confirmationService.confirm({
      header: "Delete",
      message: `Are you sure you want to delete match #${id}`,
      acceptIcon: "none",
      rejectIcon: "none",
      acceptLabel: "Sure",
      rejectLabel: "Go back",
      accept: () => this.matchService.delMatch(id),
    })
  }

  matches$ = this.matchService.matches$;
}
