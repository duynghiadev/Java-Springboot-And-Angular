import { 
    IsString, 
    IsNotEmpty, 
    IsPhoneNumber, 
    IsNumber 
} from 'class-validator';
import { CartItemDTO } from './cart.item.dto';

export class OrderDTO {
  @IsNumber()
  user_id: number;

  @IsString()
  @IsNotEmpty()
  fullname: string;

  @IsString()
  @IsNotEmpty()
  email: string;

  @IsPhoneNumber()
  phone_number: string;

  @IsString()
  @IsNotEmpty()
  address: string;

  @IsString()
  note: string;

  @IsNumber()
  total_money: number;

  @IsString()
  shipping_method: string;

  @IsString()
  payment_method: string;

  @IsString()
  coupon_code: string;

  cart_items: CartItemDTO[]; // Thêm cart_items để lưu thông tin giỏ hàng


  constructor(data: any) {
    this.user_id = data.user_id;
    this.fullname = data.fullname;
    this.email = data.email;
    this.phone_number = data.phone_number;
    this.address = data.address;
    this.note = data.note;
    this.total_money = data.total_money;
    this.shipping_method = data.shipping_method;
    this.payment_method = data.payment_method;
    this.coupon_code = data.coupon_code;
    this.cart_items = data.cart_items;
  }
}
