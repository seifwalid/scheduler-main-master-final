import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMatchFormComponent } from './components/add-match-form/add-match-form.component';
import { DeleteMatchFormComponent } from './components/delete-match-form/delete-match-form.component';

const routes: Routes = [{
  path: "addMatch",
  pathMatch: "full",
  component: AddMatchFormComponent
}, {
  path: "delMatch",
  pathMatch: "full",
  component: DeleteMatchFormComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
