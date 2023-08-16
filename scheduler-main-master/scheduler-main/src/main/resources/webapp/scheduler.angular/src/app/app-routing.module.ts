import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMatchFormComponent } from './components/add-match-form/add-match-form.component';
import { DeleteMatchTableComponent } from './components/delete-match-table/delete-match-table.component';
import { UpdateMatchTableComponent } from './components/update-match-table/update-match-table.component';
import { UpdateMatchFormComponent } from './components/update-match-form/update-match-form.component';

const routes: Routes = [{
  path: "addMatch",
  pathMatch: "full",
  component: AddMatchFormComponent
}, {
  path: "delMatch",
  pathMatch: "full",
  component: DeleteMatchTableComponent
}, {
  path: "updateMatch",
  pathMatch: "full",
  component: UpdateMatchTableComponent,
}, {
  path: "updateMatch/:id",
  pathMatch: "full",
  component: UpdateMatchFormComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
