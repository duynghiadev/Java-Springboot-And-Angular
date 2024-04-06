import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-admin',
  templateUrl: './category.admin.component.html',
  styleUrls: [
    './category.admin.component.scss',        
  ]
})
export class CategoryAdminComponent implements OnInit {
    constructor(
        private router: Router,
    ) {

    }
    ngOnInit() {

    }
}