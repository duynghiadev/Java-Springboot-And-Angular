import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { CartService } from '../../services/cart.service';
import { ProductService } from '../../services/product.service';
import { OrderService } from '../../services/order.service';
import { environment } from 'src/app/environments/environment';
import { OrderDTO } from '../../dtos/order/order.dto';
import { OrderResponse } from 'src/app/responses/order/order.response';
import { OrderDetail } from 'src/app/models/order.detail';

@Component({
  selector: 'app-order-detail',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
    ngOnInit(): void {
        
    }
}