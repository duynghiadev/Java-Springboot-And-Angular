import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-admin',
  templateUrl: './product.admin.component.html',
  styleUrls: [
    './product.admin.component.scss',        
  ]
})
export class ProductAdminComponent implements OnInit {
    constructor(
        private router: Router,
    ) {

    }
    ngOnInit() {

    }
}