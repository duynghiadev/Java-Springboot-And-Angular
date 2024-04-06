import { Component, OnInit, inject } from '@angular/core'
import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms'
import { UserService } from '../../../services/user.service'
import { Router } from '@angular/router'
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-user.admin',
  templateUrl: './user.admin.component.html',
  styleUrl: './user.admin.component.scss',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class UserAdminComponent implements OnInit {
  userService = inject(UserService)
  router = inject(Router)
  route = inject(ActivatedRoute)
  location = inject(Location)

  ngOnInit(): void {
    //get all users(paging), only Admin can do this !
  }

}
