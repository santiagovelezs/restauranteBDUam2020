import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-order',
  templateUrl: './new-order.component.html',
  styleUrls: ['./new-order.component.css']
})
export class NewOrderComponent implements OnInit 
{
  formUsuario: FormGroup

  constructor() { }

  ngOnInit(): void 
  {
    this.buildFormUsuario()
  }

  private buildFormUsuario()
  {
    this.formUsuario = new FormGroup({
      cedula: new FormControl('', [Validators.required]),      
      password: new FormControl('', [Validators.required])      
    })
  }

}
