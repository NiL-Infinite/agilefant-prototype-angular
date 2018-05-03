import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from './person';
import { PersonService } from './person.service';
import { Story } from './Story';

@Component({
  selector: 'app-persondetail',
  templateUrl: './persondetail.component.html',
  styles: []
})
export class PersondetailComponent implements OnInit, OnDestroy {
  person: Person;
  storyList: Story[];
  storyNames: number[];
  sub: any;

  constructor(private personService: PersonService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = Number.parseInt(params['id']);
      this.personService
        .get(id)
        .subscribe(p => this.person = p);
        this.storyNames = [];
        this.personService.findOfPerson(id).subscribe(s => {
          this.storyList = s;
          this.storyList.forEach(st=>{
            this.storyNames[st.id] = 0;
          })
        });
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoEdit() {
    this.router.navigate(['/person/edit', this.person.id]);
  }

  logWork(id:number) {
    this.personService.logWork(id, this.person.id, this.storyNames[id]).subscribe();
    let story = this.storyList.filter(s => s.id == id)[0];
    story.hours = Number(story.hours) + Number(this.storyNames[id]);
    this.person.totalHours = Number(this.person.totalHours  ) + Number(this.storyNames[id]);
  }

}
