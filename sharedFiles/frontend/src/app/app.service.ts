import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class AppService {

  constructor(private http: Http) { 
    console.log('AppService initialized.');
  }

  getFiles(){
    return this.http.get('http://localhost:8080/fileViewer')
                .map(res => res.json());
  }

}
