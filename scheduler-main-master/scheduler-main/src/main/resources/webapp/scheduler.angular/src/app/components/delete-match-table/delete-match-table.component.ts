import { Component } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { MatchService } from 'src/app/services/match.service';
import { MatchDisplay } from 'src/app/types/Match';

@Component({
  selector: 'app-delete-match-table',
  templateUrl: './delete-match-table.component.html',
  styleUrls: ['./delete-match-table.component.css'],
  providers: [ConfirmationService]
})
export class DeleteMatchTableComponent {
  constructor(
    private confirmationService: ConfirmationService,
    private matchService: MatchService
  ) { }

  promptDelete = ({ id }: MatchDisplay): void => {
    this.confirmationService.confirm({
      header: "Delete",
      message: `Are you sure you want to delete match #${id}`,
      acceptIcon: "none",
      rejectIcon: "none",
      acceptLabel: "Sure",
      rejectLabel: "Go back",
      accept: () => this.matchService.delMatch(id),
    });
  }
}
