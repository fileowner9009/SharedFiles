import { Component, Input, OnInit } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-view-files',
  templateUrl: './view-files.component.html', 
  providers: [AppService],
  styleUrls: ['./view-files.component.css']
})
export class ViewFilesComponent implements OnInit {

  files: File[]
  
  constructor( private appService : AppService ) { 
      this.appService.getFiles().subscribe( files => { 
          console.log("Files: " + files[0].name + " ") + files[0].path;
          this.files = files;
        } 
     );
  }

  ngOnInit() {
    
  }

}

interface File{
    name: string;
    path: string;
  }
