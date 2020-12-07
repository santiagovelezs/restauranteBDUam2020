import { NewOrderComponent } from './components/pedidos/new-order/new-order.component';
import { PanelEmpleadosComponent } from './components/empleados/panel-empleados/panel-empleados.component';
import { PanelUsuariosComponent } from './components/usuarios/panel-usuarios/panel-usuarios.component'
import { LoginComponent } from './components/usuarios/login/login.component'
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path:'', component: NewOrderComponent},
  {path:'empleados', component: PanelEmpleadosComponent},
  {path:'usuarios', component: PanelUsuariosComponent},
  {path:'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
