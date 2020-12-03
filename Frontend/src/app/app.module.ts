import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewOrderComponent } from './components/pedidos/new-order/new-order.component';
import { PanelPedidosComponent } from './components/pedidos/panel-pedidos/panel-pedidos.component';
import { PanelClientesComponent } from './components/clientes/panel-clientes/panel-clientes.component';

@NgModule({
  declarations: [
    AppComponent,
    NewOrderComponent,
    PanelPedidosComponent,
    PanelClientesComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
