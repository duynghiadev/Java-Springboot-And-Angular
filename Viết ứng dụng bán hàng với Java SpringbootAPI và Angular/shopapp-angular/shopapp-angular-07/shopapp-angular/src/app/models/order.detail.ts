import { Product } from "./product";
import {Order} from './order'
export interface OrderDetail {
    id: number;
    order: Order;
    product: Product;
    price: number;
    number_of_products: number;
    total_money: number;
    color?: string; // Dấu "?" cho biết thuộc tính này là tùy chọn
}