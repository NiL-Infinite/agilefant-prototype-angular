import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Person } from './person';
import 'rxjs/add/operator/map';
import { Story } from './Story';

@Injectable()
export class PersonService {
  private baseUrl: string = 'http://localhost:8080/SWBackend/jaxrs';

  constructor(private http: Http) {
  }

  get(id: number): Observable<Person> {
    let person$ = this.http
      .get(`${this.baseUrl}/Person/${id}`, {headers: this.getHeaders()})
      .map(mapPerson);
      return person$;
  }

  getAll(): Observable<Person[]> {
     let person$ = this.http
      .get(`${this.baseUrl}/Person`, {headers: this.getHeaders()})
      .map(mapPersons);
    return person$;
  }

  findOfPerson(id:number): Observable<Story[]> {
     let story$ = this.http
      .get(`${this.baseUrl}/Story/findOfPerson/${id}`, {headers: this.getHeaders()})
      .map(mapStories);
    return story$;
  }

  save(person: Person): Observable<Response> {
    console.log('Saving person ' + JSON.stringify(person));
    return this.http.put(`${this.baseUrl}/Person`, JSON.stringify(person), {headers: this.getHeaders()});
  }

  logWork(id: number, personId:number, hours:number): Observable<Response> {
    return this.http.put(`${this.baseUrl}/Story/logWork/${id}/${personId}/${hours}`, {headers: this.getHeaders()});
  }

  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }
}

function mapPersons(response: Response): Person[] {
  return response.json().map(toPerson);
}

function mapPerson(response: Response): Person {
  return toPerson(response.json());
}

function mapStories(response: Response): Story[] {
  return response.json().map(mapStory);
}

function mapStory(response: Response): Story {
  return toStory(response);
}

function toStory(r: any): Story {
  return r;
}

function toPerson(r: any): Person {
  return r;
}

